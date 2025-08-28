<script>
	import axios from 'axios';
	import apiClient from "$lib/api.js";

	// For the response message
	let message = $state('');

	const handleClick = async () => {
		console.log('CLICKED');
		try {
			const response = await apiClient.get(`/api/test`);
			message = response.data;
			console.log(message);
		} catch (err) {
			console.log('Error ', err);
		}
	};

	let name = $state('');
	let dob = $state('');
	let interests = $state('');
	let statusMessage = $state('');

	const handleAddUser = async () => {
		console.log(`Trying to add a new user with ${name} ${dob} ${interests}`);

		const newUser = {
			name: name,
			dob: dob,
			interests: interests
		};

		try {
			const res = await apiClient.post(`/api/users`, newUser)

			statusMessage = `Added user ${res.data.id}`;

			console.log(`Added user successfully ${statusMessage}`);

			name = '';
			dob = '';
			interests = '';
		} catch (err) {
			statusMessage = `Could not add error due to error ${err}`;
			console.log('Error adding user', err);
		}
	};

	let deleteId = $state('');
	const handleDeleteUser = async () => {
		try {
			await apiClient.delete(`/api/users/${deleteId}`)

			statusMessage = `Deleted user ${deleteId}`;
			deleteId = '';

			console.log(`DELETED USER SUCCESSFULLY ${deleteId}`);
		} catch (err) {
			if (err.response && err.response.status === 404) {
				statusMessage = `Error deleting as a user with ID ${deleteId} doesn't exist`;
			} else {
				statusMessage = `Error could not delete user ${err.message}`;
			}
			console.log('ERROR DELETING USER ', err);
		}
	};

	let userList = $state([]);
	const handleListUsers = async () => {
		try {
			const res = await apiClient.get(`/api/users`)
			userList = res.data;
			statusMessage = `Fetched ${userList.length} users.`;

			console.log('THE USER LIST IS ', userList);
		} catch (err) {
			statusMessage = `Error can't fetch users ${err.message}`;
			console.log('Could not fetch all users there was an error ', err);
		}
	};
</script>

<h1>This is my portfolio website this is an example testing with frontend .env variable</h1>

<button
	class="m-4 rounded-2xl bg-green-200 p-4 hover:cursor-pointer active:bg-green-500"
	on:click={handleClick}
>
	<h1>Hello World</h1>
</button>

{#if message}
	<div>{message}</div>
{/if}

<h1 class="bg-blue-200 text-2xl">Add new user</h1>

<form on:submit|preventDefault={handleAddUser} class="flex max-w-md flex-col gap-4">
	<div>
		<label for="name" class="block font-medium">Name:</label>
		<input id="name" type="text" bind:value={name} class="w-full rounded-md border p-2" required />
	</div>

	<div>
		<label for="dob" class="block font-medium">Date of Birth:</label>
		<input id="dob" type="date" bind:value={dob} class="w-full rounded-md border p-2" required />
	</div>

	<div>
		<label for="interests" class="block font-medium">Interests:</label>
		<input
			id="interests"
			type="text"
			bind:value={interests}
			class="w-full rounded-md border p-2"
			required
		/>
	</div>

	<button type="submit" class="rounded-md bg-blue-500 p-2 text-white hover:bg-blue-600">
		Add User
	</button>
</form>

<h1 class="mt-4 bg-blue-200 text-2xl">Delete User</h1>

<form on:submit|preventDefault={handleDeleteUser} class="flex max-w-md flex-col gap-4">
	<div>
		<label for="name" class="block font-medium">Delete user:</label>
		<input
			id="name"
			type="text"
			bind:value={deleteId}
			class="w-full rounded-md border p-2"
			required
		/>
	</div>
	<button type="submit" class="rounded-md bg-blue-500 p-2 text-white hover:bg-blue-600">
		Delete User
	</button>
</form>

<button on:click={handleListUsers} class="mt-4 rounded-3xl bg-gray-300 p-4">
	Fetch all users
</button>

{#if statusMessage}
	<div>{statusMessage}</div>
{/if}

{#if userList.length > 0}
	<table class="mt-4 w-full max-w-md border-collapse">
		<thead>
			<tr class="bg-gray-200">
				<th class="border p-2 text-left">ID</th>
				<th class="border p-2 text-left">Name</th>
				<th class="border p-2 text-left">DOB</th>
				<th class="border p-2 text-left">Interests</th>
			</tr>
		</thead>
		<tbody>
			{#each userList as user (user.id)}
				<tr class="hover:bg-gray-100">
					<td class="border p-2">{user.id}</td>
					<td class="border p-2">{user.name}</td>
					<td class="border p-2">{user.dob}</td>
					<td class="border p-2">{user.interests}</td>
				</tr>
			{/each}
		</tbody>
	</table>
{/if}

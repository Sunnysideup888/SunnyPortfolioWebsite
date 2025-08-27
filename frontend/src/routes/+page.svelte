<script>
	import axios from 'axios';

	// For the response message
	let message = '';

	const handleClick = async () => {
		console.log('CLICKED');
		try {
			const response = await axios.get('http://localhost:8080/api/test');
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
		console.log(`Trying to add a new user with ${name} ${dob} ${interests}`)

		const newUser = {
			"name": name,
			"dob": dob,
			"interests": interests
		}

		try {
			const res = await axios.post('http://localhost:8080/api/users', newUser);

			statusMessage = `Added user ${res.data.id}`

			console.log(`Added user successfully ${statusMessage}`)

			name = ''
			dob = ''
			interests = ''
		} catch (err) {
			statusMessage = `Could not add error due to error ${err}`
			console.log("Error adding user", err)
		}
	}
</script>

<h1>This is my portfolio website this is an example</h1>

<button
	class="m-4 rounded-2xl bg-green-200 p-4 hover:cursor-pointer active:bg-green-500"
	on:click={handleClick}
>
	<h1>Hello World</h1>
</button>

{#if message}
	<div>{message}</div>
{/if}

<h1 class="text-2xl bg-blue-200">Add new user</h1>

<form on:submit|preventDefault={handleAddUser} class="flex flex-col gap-4 max-w-md">
	<div>
		<label for="name" class="block font-medium">Name:</label>
		<input id="name" type="text" bind:value={name} class="w-full border rounded-md p-2" required />
	</div>

	<div>
		<label for="dob" class="block font-medium">Date of Birth:</label>
		<input id="dob" type="date" bind:value={dob} class="w-full border rounded-md p-2" required />
	</div>

	<div>
		<label for="interests" class="block font-medium">Interests:</label>
		<input id="interests" type="text" bind:value={interests} class="w-full border rounded-md p-2" required />
	</div>

	<button type="submit" class="bg-blue-500 text-white rounded-md p-2 hover:bg-blue-600">
		Add User
	</button>
</form>

{#if statusMessage}
	<div>{statusMessage}</div>
{/if}
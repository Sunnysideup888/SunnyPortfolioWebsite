<script lang="js">
	import DotBackground from '$lib/components/ui/DotBackground.svelte';
	import { fly } from 'svelte/transition';
	import { onMount } from 'svelte';
	import { Label } from 'bits-ui';
	import { toast } from 'svelte-sonner';
	import apiClient from '$lib/api.js';

	let isVisible = $state(false);
	let email = $state('');
	let name = $state('');
	let message = $state('');

	const formSubmit = () => {
		// console.log(`Email ${email} and name ${name} and message ${message}`);
		if (email === '' || name === '' || message === '') {
			toast.error('Fill out all the fields');
			return;
		}

		apiClient
			.post(`/api/sendEmail`, {
				name: name,
				email: email,
				message: message
			})
			.then(function (res) {
				toast.success(res.data.message);
				email = '';
				name = '';
				message = '';
			})
			.catch(function (err) {
				toast.error(`Something has gone wrong on the backend "${err.message}"`);
			});
	};

	onMount(() => {
		isVisible = true;
	});
</script>

<DotBackground>
	{#if isVisible}
		<div
			class="flex h-[500px] w-full flex-col items-center justify-center gap-2 p-0"
			in:fly={{ y: 20, duration: 800 }}
		>
			<h1 class="pt-0 text-5xl font-[600] text-black">Contact</h1>
			<p class="text-black">Get in touch!</p>

			<div class="flex w-[70%] flex-col gap-2">
				<Label.Root for="email" class="font-medium">Email</Label.Root>
				<input
					type="email"
					id="email"
					placeholder="Enter your email"
					class="border-input flex h-10 w-full rounded-md border border-[#e5e4e5] px-3 py-2 text-sm"
					bind:value={email}
				/>

				<Label.Root for="name" class="font-medium">Name</Label.Root>
				<input
					type="text"
					id="name"
					placeholder="Enter full name"
					class="border-input flex h-10 w-full rounded-md border border-[#e5e4e5] px-3 py-2 text-sm"
					bind:value={name}
				/>

				<Label.Root for="message" class="font-medium">Message</Label.Root>
				<textarea
					id="message"
					placeholder="Message"
					rows="3"
					class="border-input flex w-full rounded-md border border-[#e5e4e5] px-3 py-2 text-sm"
					bind:value={message}
				>
				</textarea>

				<button
					class="text-background relative m-2 w-[30%] self-center rounded-2xl bg-[#aacacf] p-2 duration-300 hover:scale-105 hover:cursor-pointer"
					on:click={formSubmit}
				>
					Send
				</button>
			</div>
		</div>
	{/if}
</DotBackground>

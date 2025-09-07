<script>
	import { onMount } from 'svelte';
	import CodingEffectBackground from '$lib/components/ui/CodingEffectBackground.svelte';

	let { text = '', class: className = '' } = $props();

	let randomString = $state('');

	// Helper function to create a random string
	const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
	const generateRandomString = (length) => {
		let result = '';
		for (let i = 0; i < length; i++) {
			result += characters.charAt(Math.floor(Math.random() * characters.length));
		}
		return result;
	};

	// Create the random string when the component first mounts
	onMount(() => {
		randomString = generateRandomString(1500);
	});

	// When the mouse moves, change the random string
	function onMouseMove() {
		randomString = generateRandomString(1500);
	}
</script>

<div
	class="relative flex h-full w-full items-center justify-center bg-transparent p-0.5 {className}"
>
	<div
		onmousemove={onMouseMove}
		class="group/card relative flex h-full w-full items-center justify-center overflow-hidden rounded-3xl bg-transparent"
		role="presentation"
	>
		<CodingEffectBackground {randomString} />
		<div class="relative z-10 flex items-center justify-center">
			<div
				class="relative flex h-44 w-44 items-center justify-center rounded-full text-4xl font-[550] text-white"
			>
				<span class="z-20 text-4xl text-white dark:text-white">{text}</span>
			</div>
		</div>
	</div>
</div>

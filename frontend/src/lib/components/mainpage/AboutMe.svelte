<script>
	import { fly } from 'svelte/transition';
	import { onMount } from 'svelte';
	import { Plus } from 'phosphor-svelte';

	let isVisible = $state(false);
	onMount(() => {
		isVisible = true;
	});
</script>

{#if isVisible}
	<div
		class="relative flex h-[650px] w-full flex-col items-center justify-center overflow-hidden bg-red-50 p-4"
		in:fly={{ y: 20, duration: 800 }}
	>
		<img
			src="/sunny_snow_background.jpg"
			alt="Me in the snow"
			class="absolute inset-0 h-full w-full object-cover"
		/>
		<div
			class="absolute top-1/2 left-1/2 z-10 w-[90%] sm:w-100 -translate-x-1/2 -translate-y-1/2 sm:left-auto sm:translate-x-0 md:right-[6%] lg:right-[15%]"
		>
			<div
				class="relative mx-auto flex flex-1 flex-col items-start border border-black/[0.2] bg-white p-4 opacity-90 transition-transform duration-300 ease-in-out hover:scale-101 dark:border-white/[0.2]"
				in:fly={{ y: 20, duration: 800 }}
			>
				<Plus class="absolute -top-3 -left-3 h-6 w-6 text-black dark:text-white" />
				<Plus class="absolute -bottom-3 -left-3 h-6 w-6 text-black dark:text-white" />
				<Plus class="absolute -top-3 -right-3 h-6 w-6 text-black dark:text-white" />
				<Plus class="absolute -right-3 -bottom-3 h-6 w-6 text-black dark:text-white" />

				<h1 class="text-5xl font-[600] text-black">About Me</h1>
				<h2 class="text-l mt-4 font-light text-black dark:text-white">
					Currently I'm in Year 2 of a Computer Science degree at UNSW, and have enjoyed getting
					involved in student life through societies such as CSESoc and Project Hope UNSW. I'm also
					a Co-op scholar and received the Scientia scholarship, and was on the Dean's list for
					2024. In my spare time, I love travelling and taking photos.
				</h2>
				<h2 class="text-l mt-4 font-light text-black dark:text-white">
					At the moment I'm interning at the Reserve Bank of Australia (RBA) Business Analysis team,
					and also a lab demo tutor for Algorithm Design and Analysis (COMP3121)
				</h2>
				<a
					class="mt-4 rounded-full border border-black/[0.2] px-2 py-0.5 text-sm font-light text-black hover:cursor-pointer dark:border-white/[0.2] dark:text-white"
					href="/gallery"
				>
					Gallery
				</a>
			</div>
		</div>

		<div
			class="absolute inset-x-0 top-0 h-1/5 bg-gradient-to-b from-[#aacbce] to-transparent"
		></div>
	</div>
{/if}

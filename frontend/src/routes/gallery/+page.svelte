<script>
	import { onMount } from 'svelte';
	import { fly } from 'svelte/transition';

	let isMounted = false;

	onMount(() => {
		isMounted = true;
	});
</script>

{#if isMounted}
	<div class="flex w-[100%] flex-col items-center justify-center">
		<div class="flex w-[100%] flex-col gap-4 text-center">
			<div
				class="relative h-[280px] w-full bg-cover bg-center"
				style="background-image: url('/sunny_lake_gallery.jpg');"
			>
				<div class="absolute inset-0 bg-black/0"></div>

				<div
					class="relative z-10 flex h-full flex-col items-center justify-center gap-4 text-white"
				>
					<h1 class="text-5xl font-[550] sm:text-6xl" in:fly={{ y: 20, duration: 600, delay: 100 }}>
						Photography Gallery
					</h1>
					<p class="sm:text-l" in:fly={{ y: 20, duration: 600, delay: 300 }}>
						A collection of photographs from the past few years
					</p>
				</div>
			</div>
		</div>
	</div>
{/if}

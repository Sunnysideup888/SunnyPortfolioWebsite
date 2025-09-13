<script lang="js">
	import PortfolioCard from '$lib/components/ui/PortfolioCard.svelte';
	import { crossfade } from 'svelte/transition';
	import { cubicInOut } from 'svelte/easing';

	let { data } = $props();
	let displayIndex = $state(null);

	let leaveTimer;

	const [send, receive] = crossfade({
		duration: 250,
		easing: cubicInOut,
		fallback(node) {
			const style = getComputedStyle(node);
			const transform = style.transform === 'none' ? '' : style.transform;
			return {
				duration: 200,
				easing: cubicInOut,
				css: (t) => `
					transform: ${transform} scale(${t});
					opacity: ${t}
				`
			};
		}
	});

	function handleMouseEnter(index) {
		clearTimeout(leaveTimer);
		displayIndex = index;
	}

	function handleMouseLeave() {
		leaveTimer = setTimeout(() => {
			displayIndex = null;
		}, 150);
	}
</script>

<div class="container mx-auto px-4 py-10">
	<h1 class="text-center text-5xl font-bold text-black dark:text-white">Portfolio of work</h1>
	<p class="mt-2 text-center text-lg text-gray-600 dark:text-gray-300">
		Some projects from the past few years
	</p>

	<div class="mt-6 grid grid-cols-1 gap-x-2 gap-y-2 md:grid-cols-2 lg:grid-cols-3">
		{#each data.items as item, index (item.id)}
			<a
				href={`/portfolio/${item.slug}`}
				class="group relative block h-full w-full p-2"
				onmouseenter={() => handleMouseEnter(index)}
				onmouseleave={handleMouseLeave}
			>
				{#if displayIndex === index}
					<span
						class="absolute inset-0 block h-full w-full rounded-3xl bg-gray-200"
						in:receive={{ key: 'highlight-box' }}
						out:send={{ key: 'highlight-box' }}
					/>
				{/if}

				<PortfolioCard {item} />
			</a>
		{/each}
	</div>
</div>

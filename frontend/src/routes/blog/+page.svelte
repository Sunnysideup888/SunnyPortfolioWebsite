<script lang="js">
    export const prerender = false;

    import { crossfade } from 'svelte/transition';
	import { cubicInOut } from 'svelte/easing';
	import { fly } from 'svelte/transition';
	import BlogCard from '$lib/components/ui/BlogCard.svelte';
	import { SvelteMap } from 'svelte/reactivity';

	let { data } = $props();
	let displayId = $state(null);

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

	const groupedItems = $derived.by(() => {
		const groups = new SvelteMap();
		if (!data.items) return [];

		for (const item of data.items) {
			const monthYear = new Date(item.publicationDate).toLocaleString('default', {
				month: 'long',
				year: 'numeric'
			});

			if (!groups.has(monthYear)) {
				groups.set(monthYear, []);
			}
			groups.get(monthYear).push(item);
		}
		// Converts it into the form [{ monthYear, posts }]
		return Array.from(groups.entries())
			.map(([monthYear, posts]) => ({ monthYear, posts }))
			.reverse();
	});

	console.log('GROUPED ITEMS', groupedItems);

	function handleMouseEnter(id) {
		clearTimeout(leaveTimer);
		displayId = id;
	}

	function handleMouseLeave() {
		leaveTimer = setTimeout(() => {
			displayId = null;
		}, 150);
	}
</script>

<div class="container mx-auto flex flex-col items-center justify-center px-4 py-10">
	<div in:fly={{ y: 20, duration: 600, delay: 300 }}>
		<h1 class="text-center text-5xl font-[600] text-black">Blogs</h1>
		<p class="mt-2 text-center text-lg text-gray-800">Some random thoughts and fun articles</p>
	</div>

	<div class="mt-2 w-full max-w-4xl space-y-0">
		{#each groupedItems as group (group.monthYear)}
			<div class="mt-10 mb-6">
				<h2 class="text-2xl font-semibold text-gray-800">{group.monthYear}</h2>
				<hr class="mt-2 border-gray-300" />
			</div>

			{#each group.posts as item (item.id)}
				<a
					href={`/blog/${item.slug}`}
					class="group relative block h-full w-full p-2"
					onmouseenter={() => handleMouseEnter(item.id)}
					onmouseleave={handleMouseLeave}
				>
					{#if displayId === item.id}
						<span
							class="absolute inset-0 block h-full w-full rounded-3xl bg-gray-200"
							in:receive={{ key: 'highlight-box' }}
							out:send={{ key: 'highlight-box' }}
						/>
					{/if}

					<BlogCard {item} />
				</a>
			{/each}
		{/each}
	</div>
</div>

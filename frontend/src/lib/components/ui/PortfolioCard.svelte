<script>
	import { fly } from 'svelte/transition';
	let { item } = $props();
</script>

<div
	class="relative z-20 h-full overflow-hidden rounded-2xl bg-slate-50 p-4 shadow-sm transition-all duration-300 group-hover:border-slate-400 hover:scale-101"
	in:fly={{ y: 20, duration: 500 }}
>
	<img
		src={item.titleImageUrl}
		alt={`Title image for ${item.title}`}
		class="h-52 w-full rounded-lg object-cover"
	/>
	<div class="p-4">
		<h3 class="text-xl font-bold tracking-wide text-gray-800">
			{item.title}
		</h3>
		<div class="mt-1">
			{new Date(item.publicationDate).toLocaleDateString('en-AU', {
				year: 'numeric'
			})}
		</div>
		<div class="mt-2 flex flex-wrap gap-2">
			{#each item.tags as tag (tag.id)}
				<span
					class="rounded-full px-3 py-1 text-xs font-semibold text-white"
					style="background-color: {tag.color};"
				>
					{tag.name}
				</span>
			{/each}
		</div>
	</div>
</div>

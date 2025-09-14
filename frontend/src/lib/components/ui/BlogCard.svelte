<script>
	import { fly } from 'svelte/transition';
	let { item } = $props();
</script>

<div
	class="relative z-20 flex flex-col items-stretch overflow-hidden rounded-2xl bg-slate-50 p-4 shadow-sm transition-all duration-300 group-hover:border-slate-400 hover:scale-[1.005] xs:flex-row xs:items-center"
	in:fly={{ y: 20, duration: 500 }}
>
	<div class="flex flex-grow p-2">
		<div class="flex h-full flex-col gap-2">
			<h3 class="text-xl font-bold tracking-wide text-gray-800">
				{item.title}
			</h3>
			<p class="line-clamp-3 flex-grow text-sm text-gray-600">{item.caption}</p>
			<div class="text-sm">
				{new Date(item.publicationDate).toLocaleDateString('en-AU', {
					year: 'numeric',
					month: 'long',
					day: 'numeric'
				})}
			</div>
			<div class="flex flex-wrap gap-2">
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
	<div class="w-full flex-shrink-0 xs:w-56">
		<img
			src={item.titleImageUrl}
			alt={`Title image for {item.title}`}
			class="h-48 w-full rounded-lg object-cover xs:h-36"
		/>
	</div>
</div>

<script lang="js">
	import { marked } from 'marked';
	import DOMPurify from 'dompurify';
	import { onMount } from 'svelte';

	let { data } = $props();

	let renderedHtml = $state('');

	onMount(() => {
		if (data.item && data.item.contentMarkdown) {
			renderedHtml = DOMPurify.sanitize(marked.parse(data.item.contentMarkdown));
		}
	});
</script>

<div class="bg-white py-16 dark:bg-black">
	<article class="prose-md lg:prose-md mx-auto prose px-4">
		<h1 class="mb-6">{data.item.title}</h1>
		<div class="mt-0">
			{#each data.item.tags as tag (tag.id)}
				<span
					class="mr-1 rounded-full px-3 py-1 text-xs font-semibold text-white"
					style="background-color: {tag.color};"
				>
					{tag.name}
				</span>
			{/each}
		</div>
		<p>
			Published on: {new Date(data.item.publicationDate).toLocaleDateString('en-AU', {
				year: 'numeric',
				month: 'long',
				day: 'numeric'
			})}
		</p>

		{@html renderedHtml}
	</article>
</div>

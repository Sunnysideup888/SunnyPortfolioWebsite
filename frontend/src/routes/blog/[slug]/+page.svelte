<script lang="js">
	export const prerender = false;

	import { marked } from 'marked';
	import DOMPurify from 'dompurify';
	import { onMount } from 'svelte';
	import katex from 'katex';
	import markedKatex from 'marked-katex-extension';

	let { data } = $props();

	marked.use(
		markedKatex({
			katex: katex,
			throwOnError: false
		})
	);

	let renderedHtml = $state('');

	onMount(() => {
		if (data.item && data.item.contentMarkdown) {
			const mathifiedHTML = marked.parse(data.item.contentMarkdown);
			renderedHtml = DOMPurify.sanitize(marked.parse(mathifiedHTML));
		}
	});
</script>

<div class="bg-white py-16">
	<article class="prose-md lg:prose-md mx-auto prose px-4">
		<h1 class="mb-6">{data.item.title}</h1>
		<p>
			Published on: {new Date(data.item.publicationDate).toLocaleDateString('en-AU', {
				year: 'numeric',
				month: 'long',
				day: 'numeric'
			})}
		</p>
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

		{@html renderedHtml}
	</article>
</div>

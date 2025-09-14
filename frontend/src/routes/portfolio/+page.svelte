<script lang="js">
	export const prerender = false;

	import PortfolioCard from '$lib/components/ui/PortfolioCard.svelte';
	import { crossfade } from 'svelte/transition';
	import { cubicInOut } from 'svelte/easing';
	import { Combobox } from 'bits-ui';
	import { CaretUpDown } from 'phosphor-svelte';
	import { Check } from 'phosphor-svelte';
	import { CaretDoubleUp } from 'phosphor-svelte';
	import { CaretDoubleDown } from 'phosphor-svelte';
	import { Tag } from 'phosphor-svelte';
	import { browser } from '$app/environment';
	import { goto } from '$app/navigation';
	import { fly } from 'svelte/transition';
	import { SvelteURLSearchParams } from 'svelte/reactivity';

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

	let searchValue = $state('');
	let selectedTags = $state(data.activeTags);
	const options = $derived(data.allTags.map((tag) => ({ value: tag.name, label: tag.name })));
	const filteredOptions = $derived(
		searchValue === ''
			? options
			: options.filter((option) => option.label.toLowerCase().includes(searchValue.toLowerCase()))
	);

	$effect(() => {
		if (!browser) return;

		const params = new SvelteURLSearchParams(window.location.search);
		if (selectedTags.length > 0) {
			params.set('tags', selectedTags.join(','));
		} else {
			params.delete('tags');
		}

		const newUrl = `/portfolio?${params.toString()}`;
		goto(newUrl, { keepFocus: true, noScroll: true });
	});
</script>

<div class="container mx-auto px-4 py-10">
	<div in:fly={{ y: 20, duration: 600, delay: 300 }}>
		<h1 class="text-center text-5xl font-[600] text-black">Portfolio of work</h1>
		<p class="mt-2 text-center text-lg text-gray-800">Some projects from the past few years</p>
	</div>

	<div class="z-30 mt-8 flex justify-center">
		<Combobox.Root
			type="multiple"
			{options}
			bind:value={selectedTags}
			onOpenChange={(open) => {
				if (!open) searchValue = '';
			}}
		>
			<div class="relative">
				<Tag class="absolute start-3 top-1/2 size-5 -translate-y-1/2 text-gray-400" />
				<Combobox.Input
					class="flex h-11 w-full min-w-[280px] rounded-lg border border-gray-300 bg-white px-10 py-2 text-sm text-gray-900 ring-0 outline-none placeholder:text-gray-400 focus:border-gray-500 focus:ring-0 focus:outline-none"
					placeholder="Filter by tags..."
					oninput={(e) => (searchValue = e.currentTarget.value)}
				/>
				<Combobox.Trigger class="absolute end-3 top-1/2 -translate-y-1/2">
					<CaretUpDown class="size-4 text-gray-400" />
				</Combobox.Trigger>
			</div>
			<Combobox.Content
				class="data-[state=open]:animate-in data-[state=closed]:animate-out data-[state=closed]:fade-out-0 data-[state=open]:fade-in-0 data-[state=closed]:zoom-out-95 data-[state=open]:zoom-in-95 z-50 mt-2 h-72 w-[--bits-combobox-anchor-width] min-w-[var(--bits-combobox-anchor-width)] rounded-xl border border-gray-200 bg-white py-2 text-gray-900 shadow-lg select-none"
			>
				<Combobox.ScrollUpButton class="flex w-full items-center justify-center py-1">
					<CaretDoubleUp class="size-3" />
				</Combobox.ScrollUpButton>
				<Combobox.Viewport class="p-1">
					{#each filteredOptions as option (option.value)}
						<Combobox.Item
							class="relative flex cursor-default items-center rounded-md py-2 pr-2 pl-8 text-sm outline-none select-none data-[highlighted]:bg-gray-100 data-[highlighted]:text-gray-900"
							value={option.value}
							label={option.label}
						>
							{#snippet children({ selected })}
								{#if selected}
									<span class="absolute left-2 flex h-3.5 w-3.5 items-center justify-center">
										<Check class="size-4" />
									</span>
								{/if}
								{option.label}
							{/snippet}
						</Combobox.Item>
					{:else}
						<p class="p-4 text-center text-sm text-gray-500">No tags found.</p>
					{/each}
				</Combobox.Viewport>
				<Combobox.ScrollDownButton class="flex w-full items-center justify-center py-1">
					<CaretDoubleDown class="size-3" />
				</Combobox.ScrollDownButton>
			</Combobox.Content>
		</Combobox.Root>
	</div>

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

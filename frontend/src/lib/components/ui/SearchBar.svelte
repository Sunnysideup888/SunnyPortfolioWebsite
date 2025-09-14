<script lang="js">
	import { Dialog, Command } from 'bits-ui';

	import { MagnifyingGlass } from 'phosphor-svelte';
	import { Command as PhosphorCommand } from 'phosphor-svelte';
	import apiClient from '$lib/api.js';
	import { goto } from '$app/navigation';

	let open = $state(false);
	let searchResults = $state([]);
	let searchValue = $state('');

	async function handleInput(event) {
		searchValue = event.target.value;
		const query = searchValue;
		console.log(`SEARCHING: "${query}"`);

		if (!query) {
			searchResults = [];
			return;
		}

		try {
			const res = await apiClient.get(`/api/search?query=${query}`);
			// const data = res.json();
			console.log('YAYAYAY IT WOKRS: ', res.data);
			searchResults = res.data;
		} catch (err) {
			console.log('ERROR: ', err);
			searchResults = [];
		}
	}

	function handleKeydown(e) {
		if (e.key === 'k' && (e.metaKey || e.ctrlKey)) {
			e.preventDefault();
			open = !open;
		}
	}
</script>

<svelte:document onkeydown={handleKeydown} />

<Dialog.Root bind:open>
	<Dialog.Trigger
		class="hidden h-9 w-60 items-center justify-between rounded-lg bg-white px-3 text-sm text-gray-500 hover:bg-gray-100 lg:flex"
		aria-label="Search"
	>
		<div class="flex items-center gap-2">
			<MagnifyingGlass class="size-4" />
			<span>Search projects...</span>
		</div>
		<div class="flex items-center gap-1">
			<div class="flex flex-row items-center justify-center gap-0.5 opacity-50">
				<span class="text-xs"><PhosphorCommand /></span>K
			</div>
		</div>
	</Dialog.Trigger>

	<Dialog.Portal>
		<Dialog.Overlay class="fixed inset-0 z-50 bg-black/60" />
		<Dialog.Content
			class="fixed top-3/10 left-1/2 z-50 w-full max-w-xl -translate-x-1/2 -translate-y-1/2 outline-none"
		>
			<Command.Root
				shouldFilter={false}
				class="flex h-full w-full flex-col overflow-hidden rounded-lg bg-white text-gray-900 shadow-xl"
			>
				<Command.Input
					oninput={handleInput}
					class="h-11 w-full border-0 bg-transparent px-3 py-3 text-sm placeholder:text-gray-500 focus:ring-0 focus:outline-none"
					placeholder="Full text search across projects and blogs..."
				/>
				<hr class="border-gray-300" />
				<Command.List class="max-h-[300px] overflow-x-hidden overflow-y-auto">
					{#if searchResults.length === 0 && searchValue}
						<Command.Empty class="py-6 text-center text-sm">No results found.</Command.Empty>
					{/if}
					<Command.Group>
						{#each searchResults as item (item.id)}
							<Command.Item
								onSelect={() => {
									const path =
										item.type === 'BLOG' ? `/blog/${item.slug}` : `/portfolio/${item.slug}`;
									open = false;
									goto(path);
								}}
								class="flex cursor-pointer items-center justify-between rounded-md px-3 py-2 text-sm outline-none select-none data-[selected]:bg-gray-100"
							>
								<span>{item.title}</span>
								<span
									class="rounded-full px-2.5 py-0.5 text-xs font-medium text-white {item.type ===
									'BLOG'
										? 'bg-[#253571] opacity-90'
										: 'bg-green-600 opacity-90'}"
								>
									{item.type}
								</span>
							</Command.Item>
						{/each}
					</Command.Group>
				</Command.List>
			</Command.Root>
		</Dialog.Content>
	</Dialog.Portal>
</Dialog.Root>

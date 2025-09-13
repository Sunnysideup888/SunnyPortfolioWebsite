<script>
	import { onMount, tick } from 'svelte';
	import { fly } from 'svelte/transition';
	import apiClient from '$lib/api.js';

	let photos = $state([]);
	let currentPage = $state(0);
	let totalPages = $state(1);
	let isLoaded = $state(false);
	let sentinel = $state(null);
	let mounted = $state(false);

	let screenWidth = $state(0);

	let numColumns = $derived.by(() => {
		if (screenWidth < 768) {
			return 2;
		} else if (screenWidth < 1024) {
			return 3;
		}
		return 4;
	});

	let columns = $derived.by(() => {
		const cols = Array.from({ length: numColumns }, () => []);
		photos.forEach((photo, i) => {
			cols[i % numColumns].push(photo);
		});
		return cols;
	});

	async function loadMorePhotos() {
		if (isLoaded || currentPage >= totalPages) return;

		isLoaded = true;
		const res = await apiClient.get(`/api/photos?page=${currentPage}&size=12`);
		const images = (await res).data;

		photos = [...photos, ...images.content];
		totalPages = images.totalPages;
		currentPage++;
		isLoaded = false;
	}

	onMount(async () => {
		mounted = true;
		await tick();
		loadMorePhotos();

		const observer = new IntersectionObserver((entries) => {
			if (entries[0].isIntersecting) {
				loadMorePhotos();
			}
		});

		screenWidth = window.innerWidth;
		const handleResize = () => (screenWidth = window.innerWidth);
		window.addEventListener('resize', handleResize);

		const cleanupEffect = $effect.root(() => {
			$effect(() => {
				if (sentinel) {
					observer.observe(sentinel);
				}
			});
		});

		return () => {
			window.removeEventListener('resize', handleResize);
			if (sentinel) {
				observer.unobserve(sentinel);
			}
			cleanupEffect();
		};
	});
</script>

<div class="flex w-[100%] flex-col items-center justify-center">
	<div class="flex w-[100%] flex-col gap-4 text-center">
		<div
			class="relative h-[280px] w-full bg-cover bg-center"
			style="background-image: url('/sunny_lake_gallery.jpg');"
		>
			<div class="absolute inset-0 bg-black/0"></div>

			<div class="relative z-10 flex h-full flex-col items-center justify-center gap-4 text-white">
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

{#if mounted}
	<div class="flex w-[100%] flex-col items-center justify-center p-4">
		<div class="flex gap-4 px-4 lg:w-4/5">
			{#each columns as photosInColumn, colIndex (colIndex)}
				<div class="flex flex-1 flex-col gap-4">
					{#each photosInColumn as photo (photo.displayOrder)}
						<div
							class="w-full"
							in:fly={{
								y: 20,
								duration: 400,
								delay: (photo.displayOrder * numColumns + colIndex) * 5
							}}
						>
							<img src={photo.s3Url} alt={photo.altText} class="h-auto w-full rounded-lg" />
						</div>
					{/each}
				</div>
			{/each}
		</div>

		{#if currentPage < totalPages}
			<div bind:this={sentinel} class="flex h-20 w-full items-center justify-center">
				{#if isLoaded}
					<!--					<p class>Loading photos :)</p>-->
				{/if}
			</div>
		{/if}
	</div>
{/if}

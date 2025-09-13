<script>
	import { onMount } from 'svelte';
	import { fly } from 'svelte/transition';
	import apiClient from '$lib/api.js';

	// This is the json file of the first 12 images and their AWS S3 url's
	let { data } = $props();
	console.log(data.photos);

	let photos = $state(data.photos);
	let currentPage = $state(1);
	let isLoaded = $state(false);
	let sentinel = $state(null);

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
		if (isLoaded || currentPage >= data.totalPages) return;

		isLoaded = true;
		const res = apiClient.get(`/api/photos?page=${currentPage}&size=12`);
		const images = (await res).data;

		photos = [...photos, ...images.content];
		currentPage++;
		isLoaded = false;
	}

	onMount(() => {
		const observer = new IntersectionObserver((entries) => {
			if (entries[0].isIntersecting) {
				loadMorePhotos();
			}
		});

		screenWidth = window.innerWidth;
		const handleResize = () => (screenWidth = window.innerWidth);
		window.addEventListener('resize', handleResize);

		if (sentinel) {
			observer.observe(sentinel);
		}

		return () => {
			window.removeEventListener('resize', handleResize);
			if (sentinel) {
				observer.unobserve(sentinel);
			}
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

<div class="flex w-[100%] flex-col items-center justify-center p-4">
	<div class="flex gap-4 px-4 lg:w-4/5">
		{#each columns as photosInColumn, colIndex}
			<div class="flex flex-1 flex-col gap-4">
				{#each photosInColumn as photo, i}
					<div
						class="w-full"
						in:fly={{
							y: 20,
							duration: 400,
							delay: (i * numColumns + colIndex) * 80
						}}
					>
						<img src={photo.s3Url} alt={photo.altText} class="h-auto w-full rounded-lg" />
					</div>
				{/each}
			</div>
		{/each}
	</div>

	{#if currentPage < data.totalPages}
		<div bind:this={sentinel} class="flex h-20 w-full items-center justify-center">
			{#if isLoaded}
				<p class>Loading more photos</p>
			{/if}
		</div>
	{/if}
</div>

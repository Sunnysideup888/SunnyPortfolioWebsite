<script>
	import { fly } from 'svelte/transition';
	import { onMount } from 'svelte';
	import { cubicOut } from 'svelte/easing';
	import Grid from '$lib/components/ui/Grid.svelte';

	let isMounted = $state(false);

	onMount(() => {
		isMounted = true;
	});
</script>

<Grid>
	{#if isMounted}
		<div class="flex flex-col items-center gap-10 p-10 lg:flex-row lg:gap-25">
			<div
				class="flex-1.1 relative flex flex-col items-center justify-center gap-1 p-2"
				in:fly={{ y: 20, duration: 600 }}
			>
				<div
					class="absolute top-[-30%] right-[0%] size-9"
					in:fly={{ x: 100, y: -200, duration: 600, delay: 100, easing: cubicOut }}
				>
					<img src="/shapes/red_triangle.svg" alt="Red triangle" />
				</div>

				<div
					class="absolute top-[110%] right-[-3%] size-10 lg:right-[10%]"
					in:fly={{ x: 0, y: 100, duration: 600, delay: 250, easing: cubicOut }}
				>
					<img src="/shapes/blue_circle.svg" alt="Blue Circle" />
				</div>

				<div
					class="absolute top-[100%] right-[90%] size-8 md:right-[100%] lg:right-[110%]"
					in:fly={{ x: -100, y: 30, duration: 600, delay: 450, easing: cubicOut }}
				>
					<img src="/shapes/yellow_cross.svg" alt="Yellow Cross" />
				</div>

				<h1 class="p-4 text-5xl font-[600] md:text-6xl lg:text-7xl">Hello, I'm Sunny!</h1>
				<div class="w-[450px]">
					<p class="font-light">
						I'm studying Computer Science at UNSW. I love learning something new each day, and
						making things a reality!
					</p>
				</div>
			</div>
			<div class="flex-1" in:fly={{ y: 20, duration: 600, delay: 100 }}>
				<div class="h-96 w-96 overflow-hidden rounded-2xl border-10 border-white">
					<img
						class="h-full w-full scale-100 object-cover object-[50%_60%]"
						src="/profile_image_nyc.JPG"
						alt="Hero banner me amongst trees"
					/>
				</div>
			</div>
		</div>
	{/if}
</Grid>

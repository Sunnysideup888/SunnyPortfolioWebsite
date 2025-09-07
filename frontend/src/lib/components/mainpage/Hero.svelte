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
		<div class="flex flex-col items-center gap-10 xs:p-10 lg:flex-row lg:gap-25">
			<!-- Div box for the text-->
			<div
				class="flex-1.1 relative flex flex-col items-center justify-center gap-1 p-2"
				in:fly={{ y: 20, duration: 600 }}
			>
				<div
					class="absolute top-[-10%] right-[12%] size-6 sm:top-[-30%] sm:right-[0%] sm:size-9"
					in:fly={{ x: 100, y: -200, duration: 600, delay: 100, easing: cubicOut }}
				>
					<img src="/shapes/red_triangle.svg" alt="Red triangle" />
				</div>

				<div
					class="absolute top-[90%] right-[-10%] size-6 xs:top-[90%] xs:right-[-10%] xs:size-8 sm:top-[110%] sm:right-[-3%] sm:size-10 lg:right-[10%]"
					in:fly={{ x: 0, y: 100, duration: 600, delay: 250, easing: cubicOut }}
				>
					<img src="/shapes/blue_circle.svg" alt="Blue Circle" />
				</div>

				<div
					class="absolute top-[100%] right-[100%] size-6 sm:top-[100%] sm:right-[90%] sm:size-8 md:right-[100%] lg:right-[105%]"
					in:fly={{ x: -100, y: 30, duration: 600, delay: 450, easing: cubicOut }}
				>
					<img src="/shapes/yellow_cross.svg" alt="Yellow Cross" />
				</div>

				<div class="flex flex-col items-center text-center">
					<h1 class="py-3.5 text-[40px] font-[600] xs:text-5xl md:text-6xl lg:text-7xl">
						Hello, I'm Sunny!
					</h1>
                    <!-- Set the max width to be 450px so that it doesn't overflow past the edge of the screen-->
					<div class="max-w-[450px] text-[13px] xs:text-base">
						<p class="lg:-translate-x-5">
							I'm studying Computer Science at UNSW. I love learning something new each day, and
							making things a reality!
						</p>
					</div>
				</div>
			</div>
			<!-- Front page image -->
			<div class="flex-1" in:fly={{ y: 20, duration: 600, delay: 100 }}>
				<div class="size-72 overflow-hidden rounded-2xl border-10 border-white xs:size-96">
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

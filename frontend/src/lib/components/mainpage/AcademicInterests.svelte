<script>
	import CodingEffect from '$lib/components/ui/CodingEffect.svelte';
	import MathEffect from '$lib/components/ui/MathEffect.svelte';
	import { fly, fade } from 'svelte/transition';
	import { Plus } from 'phosphor-svelte';
	import { onMount } from 'svelte';

	let visible = false;
	onMount(() => {
		visible = true;
	});
</script>

{#if visible}
	<div
		class="flex w-full flex-col items-center justify-center bg-[#aacbce] p-4"
		in:fade={{ duration: 500 }}
	>
		<div class="relative flex flex-col items-center justify-center gap-3 px-10 py-8 text-center">
			<h1 class="text-5xl font-[550] text-white" in:fly={{ y: 20, duration: 800 }}>
				Academic Interests
			</h1>
			<p class="text-white" in:fly={{ y: 20, duration: 800 }}>
				Here are the three things I enjoy learning the most!
			</p>
		</div>
		<div class="flex flex-col items-center justify-center gap-10 pb-5 md:flex-row lg:w-4/5">
			<div
				class="relative mx-auto flex h-[30rem] flex-1 flex-col items-start border border-black/[0.2] bg-white p-4 transition-transform duration-300 ease-in-out hover:scale-101 dark:border-white/[0.2]"
				in:fly={{ y: 20, duration: 800 }}
			>
				<Plus class="absolute -top-3 -left-3 h-6 w-6 text-black dark:text-white" />
				<Plus class="absolute -bottom-3 -left-3 h-6 w-6 text-black dark:text-white" />
				<Plus class="absolute -top-3 -right-3 h-6 w-6 text-black dark:text-white" />
				<Plus class="absolute -right-3 -bottom-3 h-6 w-6 text-black dark:text-white" />

				<div class="h-50 w-full md:h-30 lg:h-50">
					<CodingEffect text="Computer Science" />
				</div>

				<h2 class="text-l mt-4 text-sm font-light text-black dark:text-white">
					I really enjoy learning about Artificial Intelligence, and am planning to major in AI. I
					particularly find with Computer Vision algorithms and its applications very fun.
				</h2>
				<h2 class="text-l mt-4 text-sm font-light text-black dark:text-white">
					I'm working towards becoming a full-stack developer, and trying new backend and frontend
					frameworks. Current interests involve learning AWS, Spring Boot and SvelteKit.
				</h2>
				<a
					class="mt-4 rounded-full border border-black/[0.2] px-2 py-0.5 text-sm font-light text-black hover:cursor-pointer dark:border-white/[0.2] dark:text-white"
					href="/about"
				>
					Computing Projects
				</a>
			</div>

			<div
				class="relative mx-auto flex h-[30rem] flex-1 flex-col items-start border border-black/[0.2] bg-white p-4 transition-transform duration-300 ease-in-out hover:scale-101 dark:border-white/[0.2]"
				in:fly={{ y: 20, duration: 800 }}
			>
				<Plus class="absolute -top-3 -left-3 h-6 w-6 text-black dark:text-white" />
				<Plus class="absolute -bottom-3 -left-3 h-6 w-6 text-black dark:text-white" />
				<Plus class="absolute -top-3 -right-3 h-6 w-6 text-black dark:text-white" />
				<Plus class="absolute -right-3 -bottom-3 h-6 w-6 text-black dark:text-white" />

				<div
					class="flex h-50 w-full items-center justify-center rounded-3xl bg-gradient-to-br from-stone-50 to-stone-200"
				>
					<h1 class="absolute z-10 text-3xl font-[550] text-gray-800">Mathematics</h1>
					<MathEffect class="absolute inset-0" />
				</div>

				<h2 class="mt-4 text-sm font-light text-black dark:text-white">
					I find math exciting and very fulfilling, particularly that feeling that comes when
					solving a hard problem after a long time. I am hoping to minor in Mathematics, and
					particularly enjoy the applied side.
				</h2>
				<h2 class="mt-4 text-sm font-light text-black dark:text-white">
					So far, I've taken Higher Mathematics 1A & 1B, Higher Complex Analysis and Intro to
					Atmosphere and Ocean Dynamics, scoring 94+ in all of these courses.
				</h2>
				<a
					class="mt-4 rounded-full border border-black/[0.2] px-2 py-0.5 text-sm font-light text-black hover:cursor-pointer dark:border-white/[0.2] dark:text-white"
					href="/about"
				>
					Mathematics Projects
				</a>
			</div>

			<div
				class="relative mx-auto flex h-[30rem] flex-1 flex-col items-start border border-black/[0.2] bg-white p-4 transition-transform duration-300 ease-in-out hover:scale-101 dark:border-white/[0.2]"
				in:fly={{ y: 20, duration: 800 }}
			>
				<Plus class="absolute -top-3 -left-3 h-6 w-6 text-black dark:text-white" />
				<Plus class="absolute -bottom-3 -left-3 h-6 w-6 text-black dark:text-white" />
				<Plus class="absolute -top-3 -right-3 h-6 w-6 text-black dark:text-white" />
				<Plus class="absolute -right-3 -bottom-3 h-6 w-6 text-black dark:text-white" />

				<div
					class="relative flex h-50 w-full items-center justify-center overflow-hidden rounded-3xl bg-gradient-to-br from-stone-50 to-stone-200"
				>
					<h1 class="relative z-10 text-3xl font-[550] text-white">Geography</h1>

					<img
						class="absolute inset-0 h-full w-full object-cover"
						src="/old_map.jpg"
						alt="Old map"
					/>
				</div>

				<h2 class="mt-4 text-sm font-light text-black dark:text-white">
					I just really like maps, especially printed ones. But in all seriousness, Geography is
					really interesting for its practicality and usefulness in the real world.
				</h2>
				<h2 class="mt-4 text-sm font-light text-black dark:text-white">
					While not the focus of my degree, I do enjoy reading news about the latest happenings, and
					am spending my general education electives just to learn a bit out of interest.
				</h2>
				<a
					class="mt-4 rounded-full border border-black/[0.2] px-2 py-0.5 text-sm font-light text-black hover:cursor-pointer dark:border-white/[0.2] dark:text-white"
					href="/about"
				>
					Geography Projects
				</a>
			</div>
		</div>
	</div>
{/if}

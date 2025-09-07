<script>
	import CodingEffect from '$lib/components/ui/CodingEffect.svelte';
	import MathEffect from '$lib/components/ui/MathEffect.svelte';
</script>

<div>
	<CodingEffect text="Computer Science" />
	<div
		class="relative mx-auto flex h-[30rem] flex-1 flex-col items-start border border-black/[0.2] bg-white p-4 transition-transform duration-300 ease-in-out hover:scale-101 dark:border-white/[0.2]"
	>
		<div
			class="flex h-50 w-full items-center justify-center rounded-3xl bg-gradient-to-br from-stone-50 to-stone-200"
		>
			<h1 class="absolute z-10 text-3xl font-bold text-gray-800">Mathematics</h1>
			<MathEffect classname="absolute inset-0" />
		</div>

		<h2 class="mt-4 text-sm font-light text-black dark:text-white">
			I find math exciting and very fulfilling, particularly that feeling that comes when solving a
			hard problem after a long time. I am hoping to minor in Mathematics, and particularly enjoy
			the applied side.
		</h2>
		<h2 class="mt-4 text-sm font-light text-black dark:text-white">
			So far, I've taken Higher Mathematics 1A & 1B, Higher Complex Analysis and Intro to Atmosphere
			and Ocean Dynamics, scoring 94+ in all of these courses.
		</h2>
	</div>
</div>

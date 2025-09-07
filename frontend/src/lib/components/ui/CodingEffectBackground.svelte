<script>
	// No changes needed in the script block for this effect
	let { randomString } = $props();
</script>

<div class="pointer-events-none">
	<div class="absolute inset-0 blur-md">
		<div
			class="absolute inset-0 rounded-2xl bg-gradient-to-r from-green-500 to-blue-700 opacity-40 backdrop-blur-xl"
		></div>
		<div class="absolute inset-0 rounded-2xl opacity-60 mix-blend-overlay">
			<p
				class="absolute inset-x-0 h-full font-mono text-xs font-bold break-words whitespace-pre-wrap text-white"
			>
				{randomString}
			</p>
		</div>
	</div>

	<div
		class="absolute inset-0 [mask-image:radial-gradient(ellipse_at_center,black_40%,transparent_80%)]"
	>
		<div
			class="absolute inset-0 rounded-2xl bg-gradient-to-r from-green-500 to-blue-700 opacity-40 backdrop-blur-xl"
		></div>
		<div class="absolute inset-0 rounded-2xl opacity-60 mix-blend-overlay">
			<p
				class="absolute inset-x-0 h-full font-mono text-xs font-bold break-words whitespace-pre-wrap text-white"
			>
				{randomString}
			</p>
		</div>
	</div>
</div>

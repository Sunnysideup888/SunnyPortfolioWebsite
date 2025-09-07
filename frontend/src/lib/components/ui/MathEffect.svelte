<script>
	// Component Props & State
	// prettier-ignore
	let { classname } = $props();
	let container;

	// Track mouse position, starting off-screen
	let mouseX = $state(-999);
	let mouseY = $state(-999);

	// Content Generation
	const symbols = [
		'∫',
		'∑',
		'√',
		'∞',
		'∂',
		'∇',
		'±',
		'×',
		'÷',
		'≈',
		'≠',
		'≤',
		'≥',
		'∴',
		'∵',
		'e',
		'i',
		'π'
	];
	const elements = ['sin(x)', 'cos(θ)', 'eˣ', 'f(x)dx', 'aⁿ', 'x²', 'dy/dx', 'z=a+bi'];

	const generateLine = () => {
		let line = '';
		for (let i = 0; i < 80; i++) {
			// Decide if using 'elements' or 'symbols' array.
			const useElementsArray = Math.random() < 0.2;

			if (useElementsArray) {
				line += elements[Math.floor(Math.random() * elements.length)] + ' ';
			} else {
				line += symbols[Math.floor(Math.random() * symbols.length)] + ' ';
			}
		}
		return line;
	};

	let lines = $state(Array(25).fill(null).map(generateLine));

	// Track the mouse and use it to add a slight glow mask effect
	function handleMouseMove(event) {
		if (!container) return;
		const rect = container.getBoundingClientRect();
		mouseX = event.clientX - rect.left;
		mouseY = event.clientY - rect.top;
	}

	const maskStyle = $derived(
		`mask-image: radial-gradient(120px at ${mouseX}px ${mouseY}px, white, transparent); -webkit-mask-image: radial-gradient(120px at ${mouseX}px ${mouseY}px, white, transparent);`
	);
</script>

<div
	bind:this={container}
	onmousemove={handleMouseMove}
	onmouseleave={() => {
		mouseX = -999;
		mouseY = -999;
	}}
	role="presentation"
	class="relative h-full w-full overflow-hidden {classname}"
>
	<div class="absolute inset-0 opacity-10">
		{#each lines as line, i (i)}
			<p
				class="font-mono whitespace-nowrap text-zinc-800"
				style="position: absolute; top: {i * 20}px;"
			>
				{line}
			</p>
		{/each}
	</div>

	<div class="absolute inset-0 opacity-50 transition-opacity duration-500" style={maskStyle}>
		{#each lines as line, i (i)}
			<p
				class="font-mono whitespace-nowrap text-zinc-400"
				style="position: absolute; top: {i * 20}px;"
			>
				{line}
			</p>
		{/each}
	</div>

	<div class="relative z-10">
		<slot />
	</div>
</div>

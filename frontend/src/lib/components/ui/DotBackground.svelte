<script>
</script>

<div class="relative flex h-full w-full items-center justify-center bg-[#f5f4ee] dark:bg-black">
	<div
		class="absolute inset-0 [background-image:radial-gradient(#dddddd,transparent_1.8px)] [background-size:20px_20px] dark:[background-image:radial-gradient(#dddddd_1.8px,transparent_1.8px)]"
	></div>

	<div
		class="pointer-events-none absolute inset-0 flex items-center justify-center bg-white [mask-image:radial-gradient(ellipse_at_center,transparent_100%,black)] dark:bg-black"
	></div>

	<div class="relative z-20 w-full items-center justify-center">
		<slot />
	</div>
</div>

<div class="bg-red- relative flex h-[100%] w-full items-center justify-center bg-[#FBF9F3] p-10">
	<div
		class="absolute inset-0 bg-repeat"
		style="background-image: url(/subtle_grunge_effect.png); opacity: 0.40;"
	></div>

	<div
		class="absolute inset-0 [background-image:linear-gradient(to_right,#DBD3C9_1px,transparent_1px),linear-gradient(to_bottom,#DBD3C9_1px,transparent_1px)] [background-size:40px_40px]"
	></div>

	<div
		class="pointer-events-none absolute inset-0 flex items-center justify-center bg-[#FBF9F3] [mask-image:radial-gradient(ellipse_at_center,transparent_20%,black)]"
	></div>

	<div class="relative z-20">
		<slot />
	</div>
</div>

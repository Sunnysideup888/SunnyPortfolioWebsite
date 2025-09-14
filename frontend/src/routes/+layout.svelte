<script>
	import '../app.css';
	import Navigation from '$lib/components/Navigation.svelte';
	import Footer from '$lib/components/Footer.svelte';
	import 'katex/dist/katex.min.css';
	let { children } = $props();
</script>

<svelte:head>
	<title>(dev) Sunny Chen</title>
	<meta name="description" content="Welcome to my portfolio page! Made by Sunny Chen" />
</svelte:head>

<div class="flex min-h-screen flex-col">
	<div class="flex h-5 w-full items-center justify-center bg-red-200">
		<i class="text-sm">This website is still under production.</i>
	</div>
	<Navigation />
	<main class="flex-grow">
		{@render children()}
	</main>
	<Footer />
</div>

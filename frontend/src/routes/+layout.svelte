<script>
	import '../app.css';
	import Navigation from '$lib/components/Navigation.svelte';
	import Footer from '$lib/components/Footer.svelte';
	let { children } = $props();
</script>

<svelte:head>
	<title>(dev) Sunny Chen</title>
	<meta name="description" content="Welcome to my portfolio page! Made by Sunny Chen" />
</svelte:head>

<div class="flex min-h-screen flex-col">
	<Navigation />
	<main class="flex-grow">
		{@render children()}
	</main>
	<Footer />
</div>

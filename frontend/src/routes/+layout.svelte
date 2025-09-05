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

<div>
	<Navigation />
	{@render children()}
	<Footer />
</div>

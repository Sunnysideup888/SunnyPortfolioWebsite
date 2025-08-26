<script>
	let navItems = [
		{ id: 1, path: '/', label: 'Home' },
		{ id: 2, path: '/portfolio', label: 'Portfolio' },
		{ id: 3, path: '/gallery', label: 'Gallery' },
		{ id: 4, path: '/contact', label: 'Contact' },
		{ id: 5, path: '/about', label: 'About' }
	];
</script>

<nav class="bg-white shadow">
	<div class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
		<div class="flex h-16 justify-between">
			<div class="flex space-x-8">
				{#each navItems as { id, path, label } (id)}
					<a
						href={path}
						class="inline-flex items-center px-1 pt-1 text-sm font-medium text-gray-900 hover:text-blue-600"
					>
						{label}
					</a>
				{/each}
			</div>
		</div>
	</div>
</nav>

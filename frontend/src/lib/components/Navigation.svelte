<script>
	let navItems = [
		{ path: '/', label: 'Home' },
		{ path: '/portfolio', label: 'Portfolio' },
		{ path: '/gallery', label: 'Gallery' },
		{ path: '/contact', label: 'Contact' },
		{ path: '/about', label: 'About' }
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

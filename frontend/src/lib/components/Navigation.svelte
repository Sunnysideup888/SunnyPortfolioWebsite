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
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div class="flex justify-between h-16">
            <div class="flex space-x-8">
                {#each navItems as {path, label}}
                    <a
                            href={path}
                            class="inline-flex items-center px-1 pt-1 text-gray-900 hover:text-blue-600 text-sm font-medium"
                    >
                        {label}
                    </a>
                {/each}
            </div>
        </div>
    </div>
</nav>
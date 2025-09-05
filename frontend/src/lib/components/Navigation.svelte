<script>
	import { Toaster } from 'svelte-sonner';
	import { List, House, Scroll, Image, PaperPlaneTilt, User, X } from 'phosphor-svelte';
	import { fade } from 'svelte/transition';
	import { NavigationMenu, DropdownMenu } from 'bits-ui';

	let isMobileMenuOpen = $state(false);
	let windowWidth = $state(0);

	$effect(() => {
		if (windowWidth >= 768) {
			isMobileMenuOpen = false;
		}
	});
</script>

<svelte:window bind:innerWidth={windowWidth} />
<Toaster position="top-center" richColors closeButton />

<nav class="relative z-50 flex w-full items-center justify-between bg-[#f4f3ec] py-2">
	<a href="/" class="px-2 md:px-8">
		<img src="/sunny_banner.png" alt="Sunny Chen portfolio website banner" class="h-15" />
	</a>

	<NavigationMenu.Root class="hidden px-10 md:block">
		<NavigationMenu.List class="group flex list-none items-center justify-center p-1">
			<NavigationMenu.Item>
				<NavigationMenu.Link
					class="hover:text-accent-foreground focus:bg-muted focus:text-accent-foreground data-[state=open]:shadow-mini dark:hover:bg-muted dark:data-[state=open]:bg-muted group text-l inline-flex h-8 w-max items-center justify-center rounded-[7px] bg-transparent px-4 py-2 font-[430] transition-colors hover:bg-white focus:outline-hidden disabled:pointer-events-none disabled:opacity-50 data-[state=open]:bg-white"
					href="/"
				>
					<span class="hidden sm:inline"> Home </span>
					<span class="inline sm:hidden"> Home </span>
				</NavigationMenu.Link>
			</NavigationMenu.Item>
			<NavigationMenu.Item>
				<NavigationMenu.Link
					class="hover:text-accent-foreground focus:bg-muted focus:text-accent-foreground data-[state=open]:shadow-mini dark:hover:bg-muted dark:data-[state=open]:bg-muted group text-l inline-flex h-8 w-max items-center justify-center rounded-[7px] bg-transparent px-4 py-2 font-[430] transition-colors hover:bg-white focus:outline-hidden disabled:pointer-events-none disabled:opacity-50 data-[state=open]:bg-white"
					href="/portfolio"
				>
					<span class="hidden sm:inline"> Portfolio </span>
					<span class="inline sm:hidden"> Portfolio </span>
				</NavigationMenu.Link>
			</NavigationMenu.Item>
			<NavigationMenu.Item>
				<NavigationMenu.Link
					class="hover:text-accent-foreground focus:bg-muted focus:text-accent-foreground data-[state=open]:shadow-mini dark:hover:bg-muted dark:data-[state=open]:bg-muted group text-l inline-flex h-8 w-max items-center justify-center rounded-[7px] bg-transparent px-4 py-2 font-[430] transition-colors hover:bg-white focus:outline-hidden disabled:pointer-events-none disabled:opacity-50 data-[state=open]:bg-white"
					href="/gallery"
				>
					<span class="hidden sm:inline"> Gallery </span>
					<span class="inline sm:hidden"> Gallery </span>
				</NavigationMenu.Link>
			</NavigationMenu.Item>
			<NavigationMenu.Item>
				<NavigationMenu.Link
					class="hover:text-accent-foreground focus:bg-muted focus:text-accent-foreground data-[state=open]:shadow-mini dark:hover:bg-muted dark:data-[state=open]:bg-muted group text-l inline-flex h-8 w-max items-center justify-center rounded-[7px] bg-transparent px-4 py-2 font-[430] transition-colors hover:bg-white focus:outline-hidden disabled:pointer-events-none disabled:opacity-50 data-[state=open]:bg-white"
					href="/contact"
				>
					<span class="hidden sm:inline"> Contact </span>
					<span class="inline sm:hidden"> Contact </span>
				</NavigationMenu.Link>
			</NavigationMenu.Item>
			<NavigationMenu.Item>
				<NavigationMenu.Link
					class="hover:text-accent-foreground focus:bg-muted focus:text-accent-foreground data-[state=open]:shadow-mini dark:hover:bg-muted dark:data-[state=open]:bg-muted group text-l inline-flex h-8 w-max items-center justify-center rounded-[7px] bg-transparent px-4 py-2 font-[430] transition-colors hover:bg-white focus:outline-hidden disabled:pointer-events-none disabled:opacity-50 data-[state=open]:bg-white"
					href="/about"
				>
					<span class="hidden sm:inline"> About </span>
					<span class="inline sm:hidden"> About </span>
				</NavigationMenu.Link>
			</NavigationMenu.Item>

			<NavigationMenu.Indicator
				class="data-[state=hidden]:animate-fade-out data-[state=visible]:animate-fade-in top-full flex h-2.5 items-end justify-center overflow-hidden opacity-100 transition-[all,transform_250ms_ease] duration-200 data-[state=hidden]:opacity-0"
			>
				<div class="relative top-[70%] size-2.5 rotate-[45deg] rounded-tl-[2px]"></div>
			</NavigationMenu.Indicator>
		</NavigationMenu.List>
		<div class="absolute top-full left-0 flex w-full justify-center perspective-[2000px]">
			<NavigationMenu.Viewport
				class="text-popover-foreground bg-background data-[state=closed]:animate-scale-out data-[state=open]:animate-scale-in relative mt-2.5 h-[var(--bits-navigation-menu-viewport-height)] w-full origin-[top_center] overflow-hidden rounded-md shadow-lg transition-[width,_height] duration-200 sm:w-[var(--bits-navigation-menu-viewport-width)] "
			/>
		</div>
	</NavigationMenu.Root>

	<!-- This is when the screen gets small! -->
	<DropdownMenu.Root bind:open={isMobileMenuOpen}>
		<DropdownMenu.Trigger
			class="text-foreground shadow-btn hover:bg-muted mx-8 inline-flex h-10 w-10 items-center justify-center rounded-full bg-[#f5f4ee] text-sm select-none active:scale-[0.98] md:hidden"
		>
			{#if isMobileMenuOpen}
				<X class="text-foreground h-6 w-6" />
			{:else}
				<List class="text-foreground h-6 w-6" />
			{/if}
		</DropdownMenu.Trigger>
		<DropdownMenu.Portal>
			<DropdownMenu.Content forceMount sideOffset={8}>
				{#snippet child({ wrapperProps, props, open })}
					{#if open}
						<div {...wrapperProps} transition:fade={{ duration: 150 }}>
							<div
								{...props}
								class="{props.class} shadow-popover z-100 w-[229px] rounded-xl bg-[#f5f4ee] px-1.5 py-1.5 outline-none"
							>
								<DropdownMenu.Item asChild>
									<a
										href="/"
										class="rounded-button data-highlighted:bg-muted flex h-10 items-center rounded-2xl py-3 pr-1.5 pl-3 text-sm ring-0! ring-transparent! transition-colors duration-200 select-none hover:bg-[#eeead1] focus-visible:outline-none"
									>
										<House class="text-foreground-alt mr-2 size-5" />
										Home
									</a>
								</DropdownMenu.Item>
								<DropdownMenu.Item asChild>
									<a
										href="/portfolio"
										class="rounded-button data-highlighted:bg-muted flex h-10 items-center rounded-2xl py-3 pr-1.5 pl-3 text-sm ring-0! ring-transparent! transition-colors duration-200 select-none hover:bg-[#eeead1] focus-visible:outline-none"
									>
										<Scroll class="text-foreground-alt mr-2 size-5" />
										Portfolio
									</a>
								</DropdownMenu.Item>
								<DropdownMenu.Item asChild>
									<a
										href="/gallery"
										class="rounded-button data-highlighted:bg-muted flex h-10 items-center rounded-2xl py-3 pr-1.5 pl-3 text-sm ring-0! ring-transparent! transition-colors duration-200 select-none hover:bg-[#eeead1] focus-visible:outline-none"
									>
										<Image class="text-foreground-alt mr-2 size-5" />
										Gallery
									</a>
								</DropdownMenu.Item>
								<DropdownMenu.Item asChild>
									<a
										href="/contact"
										class="rounded-button data-highlighted:bg-muted flex h-10 items-center rounded-2xl py-3 pr-1.5 pl-3 text-sm ring-0! ring-transparent! transition-colors duration-200 select-none hover:bg-[#eeead1] focus-visible:outline-none"
									>
										<PaperPlaneTilt class="text-foreground-alt mr-2 size-5" />
										Contact
									</a>
								</DropdownMenu.Item>
								<DropdownMenu.Item asChild>
									<a
										href="/about"
										class="rounded-button data-highlighted:bg-muted flex h-10 items-center rounded-2xl py-3 pr-1.5 pl-3 text-sm ring-0! ring-transparent! transition-colors duration-200 select-none hover:bg-[#eeead1] focus-visible:outline-none"
									>
										<User class="text-foreground-alt mr-2 size-5" />
										About
									</a>
								</DropdownMenu.Item>
							</div>
						</div>
					{/if}
				{/snippet}
			</DropdownMenu.Content>
		</DropdownMenu.Portal>
	</DropdownMenu.Root>
</nav>

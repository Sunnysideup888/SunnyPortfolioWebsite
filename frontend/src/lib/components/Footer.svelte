<script>
	import { NavigationMenu } from 'bits-ui';
</script>

<nav
	class="relative z-50 flex w-full items-center justify-center border-t border-[#ececed] bg-[#f4f3ec] py-2"
>
	<div class="flex flex-col items-center justify-center gap-2 p-4 md:gap-3">
		<NavigationMenu.Root class="block px-10">
			<NavigationMenu.List class="group flex list-none items-center justify-center p-1">
				<NavigationMenu.Item>
					<NavigationMenu.Link
						class="hover:text-accent-foreground focus:bg-muted focus:text-accent-foreground data-[state=open]:shadow-mini dark:hover:bg-muted dark:data-[state=open]:bg-muted group text-l inline-flex h-8 w-max items-center justify-center rounded-[7px] bg-transparent px-4 py-2 font-[450] transition-colors hover:bg-white focus:outline-hidden disabled:pointer-events-none disabled:opacity-50 data-[state=open]:bg-white"
						href="/"
					>
						<span class="hidden sm:inline"> Home </span>
						<span class="inline sm:hidden"> Home </span>
					</NavigationMenu.Link>
				</NavigationMenu.Item>
				<NavigationMenu.Item>
					<NavigationMenu.Link
						class="hover:text-accent-foreground focus:bg-muted focus:text-accent-foreground data-[state=open]:shadow-mini dark:hover:bg-muted dark:data-[state=open]:bg-muted group text-l inline-flex h-8 w-max items-center justify-center rounded-[7px] bg-transparent px-4 py-2 font-[450] transition-colors hover:bg-white focus:outline-hidden disabled:pointer-events-none disabled:opacity-50 data-[state=open]:bg-white"
						href="/portfolio"
					>
						<span class="hidden sm:inline"> Portfolio </span>
						<span class="inline sm:hidden"> Portfolio </span>
					</NavigationMenu.Link>
				</NavigationMenu.Item>
				<NavigationMenu.Item>
					<NavigationMenu.Link
						class="hover:text-accent-foreground focus:bg-muted focus:text-accent-foreground data-[state=open]:shadow-mini dark:hover:bg-muted dark:data-[state=open]:bg-muted group text-l inline-flex h-8 w-max items-center justify-center rounded-[7px] bg-transparent px-4 py-2 font-[450] transition-colors hover:bg-white focus:outline-hidden disabled:pointer-events-none disabled:opacity-50 data-[state=open]:bg-white"
						href="/gallery"
					>
						<span class="hidden sm:inline"> Gallery </span>
						<span class="inline sm:hidden"> Gallery </span>
					</NavigationMenu.Link>
				</NavigationMenu.Item>
				<NavigationMenu.Item>
					<NavigationMenu.Link
						class="hover:text-accent-foreground focus:bg-muted focus:text-accent-foreground data-[state=open]:shadow-mini dark:hover:bg-muted dark:data-[state=open]:bg-muted group text-l inline-flex h-8 w-max items-center justify-center rounded-[7px] bg-transparent px-4 py-2 font-[450] transition-colors hover:bg-white focus:outline-hidden disabled:pointer-events-none disabled:opacity-50 data-[state=open]:bg-white"
						href="/contact"
					>
						<span class="hidden sm:inline"> Contact </span>
						<span class="inline sm:hidden"> Contact </span>
					</NavigationMenu.Link>
				</NavigationMenu.Item>
				<NavigationMenu.Item>
					<NavigationMenu.Link
						class="hover:text-accent-foreground focus:bg-muted focus:text-accent-foreground data-[state=open]:shadow-mini dark:hover:bg-muted dark:data-[state=open]:bg-muted group text-l inline-flex h-8 w-max items-center justify-center rounded-[7px] bg-transparent px-4 py-2 font-[450] transition-colors hover:bg-white focus:outline-hidden disabled:pointer-events-none disabled:opacity-50 data-[state=open]:bg-white"
						href="/about"
					>
						<span class="hidden sm:inline"> About </span>
						<span class="inline sm:hidden"> About </span>
					</NavigationMenu.Link>
				</NavigationMenu.Item>

				<NavigationMenu.Indicator
					class="data-[state=hidden]:animate-fade-out data-[state=visible]:animate-fade-in top-full flex h-2.5 items-end justify-center overflow-hidden opacity-100 transition-[all,transform_250ms_ease] duration-200 data-[state=hidden]:opacity-0"
				>
					<div class="bg-border relative top-[70%] size-2.5 rotate-[45deg] rounded-tl-[2px]"></div>
				</NavigationMenu.Indicator>
			</NavigationMenu.List>
			<div class="absolute top-full left-0 flex w-full justify-center perspective-[2000px]">
				<NavigationMenu.Viewport
					class="text-popover-foreground bg-background data-[state=closed]:animate-scale-out data-[state=open]:animate-scale-in relative mt-2.5 h-[var(--bits-navigation-menu-viewport-height)] w-full origin-[top_center] overflow-hidden rounded-md border shadow-lg transition-[width,_height] duration-200 sm:w-[var(--bits-navigation-menu-viewport-width)] "
				/>
			</div>
		</NavigationMenu.Root>

		<p>© Sunny Chen 2025</p>

		<p class="p-2 text-xs">
			Made using SvelteKit and SpringBoot. Check out the repo <a
				href="https://github.com/Sunnysideup888/SunnyPortfolioWebsite"
				target="_blank"
				class="hover:underline">here</a
			>.
		</p>
	</div>
</nav>

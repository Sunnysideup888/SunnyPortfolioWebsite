import adapter from '@sveltejs/adapter-static';

/** @type {import('@sveltejs/kit').Config} */
const config = {
	kit: {
		adapter: adapter({
			pages: 'build',
			assets: 'build',
			fallback: 'index.html'
		})
	},
	compilerOptions: {
		// Just to force me to use Svelte 5
		runes: true
	}
};

export default config;

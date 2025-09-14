import apiClient from '$lib/api.js';
import { error } from '@sveltejs/kit';

export async function load({ url }) {
	try {
		const params = url.searchParams.get('tags');
		const splitParams = params ? params.split(',') : [];

		const filterParams = new URLSearchParams({
			type: 'BLOG'
		});

		if (splitParams.length > 0) {
			filterParams.append('tags', splitParams.join(','));
		}
		const res = apiClient.get(`/api/filter?${filterParams}`);
		const tags = apiClient.get('/api/tags');

		const [items, allTags] = await Promise.all([res, tags]);

		return {
			items: items.data,
			allTags: allTags.data,
			activeTags: splitParams
		};
	} catch (err) {
		throw error(500, "Couldn't load portfolio data :(");
	}
}

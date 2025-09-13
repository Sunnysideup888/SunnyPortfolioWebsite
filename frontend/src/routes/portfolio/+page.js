import apiClient from '$lib/api.js';

export async function load() {
	const res = await apiClient.get('/api/filter?type=PORTFOLIO');
	return {
		items: res.data
	};
}

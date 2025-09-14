import apiClient from '$lib/api.js';
import { error } from '@sveltejs/kit';

export async function load({ params }) {
	try {
		const response = await apiClient.get(`/api/slug/${params.slug}`);
		return {
			item: response.data
		};
	} catch (err) {
		throw error(404, 'This post could not be found.');
	}
}

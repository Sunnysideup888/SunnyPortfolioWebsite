import apiClient from '$lib/api.js';
import { error } from '@sveltejs/kit';

export async function load({ params }) {
	try {
        console.log(`THE FULL URL IS ${apiClient.defaults.baseURL}/api/slug/${params.slug}`)
		const response = await apiClient.get(`/api/slug/${params.slug}`);
        console.log("THIS IS THE RESPONSE.DATA ON THE BLOG", response.data)
        console.log("Successful")
		return {
			item: response.data
		};
	} catch (err) {
        console.log("THIS IS THE ERROR ", err)
        console.log('Error data:', err.response.data);
        console.log('Error status:', err.response.status);
        console.log('Error headers:', err.response.headers);
        throw error(404, 'This post could not be found.');
	}
}

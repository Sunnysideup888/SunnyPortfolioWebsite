import apiClient from '$lib/api.js';

// This loads the images for the gallery at the very start (it takes the first 12 ones by default)
export async function load() {
	const res = apiClient.get(`/api/photos`);
	const images = (await res).data;

	return {
		photos: images.content,
		totalPages: images.totalPages
	};
}

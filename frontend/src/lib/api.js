import axios from 'axios';
import { PUBLIC_API_BASE_URL } from '$env/static/public';

const apiClient = axios.create({
	baseURL: PUBLIC_API_BASE_URL,
	headers: {
		'Content-Type': 'application/json'
	}
});

export default apiClient;

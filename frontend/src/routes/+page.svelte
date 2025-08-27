<script>
	import axios from "axios";

	let message = '';

	const handleClick = async () => {
		console.log("CLICKED")
		try {
			const response = await axios.get('http://localhost:8080/api/test');
			message = response.data;
			console.log(message)
		} catch (err) {
			console.log("Error ", err)
		}

	};
</script>

<h1>This is my portfolio website</h1>

<button
	class="m-4 rounded-2xl bg-green-200 p-4 hover:cursor-pointer active:bg-green-500"
	on:click={handleClick}
>
	<h1>Hello World</h1>
</button>

{#if message}
	<div>{message}</div>
{/if}

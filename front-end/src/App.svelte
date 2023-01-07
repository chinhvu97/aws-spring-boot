<script>
	import { onMount } from "svelte";
	import {listHotels} from './hotel/hotel.js'
	onMount(async () => {
		fetch(
			"http://localhost:8080/hotel"
		)
			.then((response) => response.json())
			.then((data) => {
				console.log(data);
				listHotels.set(data);
			})
			.catch((error) => {
				console.log(error);
				return [];
			});
	});
	export let name;
</script>

<main>
	<h1>Hello {name}!</h1>
	<ul>
		{#each $listHotels as hotel}
			<li>{hotel.name}</li>
		{/each}
		</ul>
</main>

<style>
	main {
		text-align: center;
		padding: 1em;
		max-width: 240px;
		margin: 0 auto;
	}

	h1 {
		color: #ff3e00;
		text-transform: uppercase;
		font-size: 4em;
		font-weight: 100;
	}

	@media (min-width: 640px) {
		main {
			max-width: none;
		}
	}
</style>

<script>
	import { fly } from 'svelte/transition';
	import { Accordion } from 'bits-ui';
	import CaretDown from 'phosphor-svelte/lib/CaretDown';
	import { slide } from 'svelte/transition';

	// Note to me: You can add "university" or "high_school" here if you want the dropdowns to be opened on first load
	let value = $state([]);
</script>

<div class="about bg-[#faf6f2] px-8 py-8 lg:px-20">
	<div class="flex flex-col gap-10 xs:p-10 lg:flex-row lg:items-start lg:gap-5">
		<div class="flex flex-1 justify-center" in:fly={{ y: 20, duration: 600 }}>
			<div
				class="h-72 w-72 overflow-hidden rounded-2xl border-8 border-white shadow-lg xs:h-96 xs:w-96 lg:h-auto lg:w-full lg:max-w-sm"
			>
				<img
					class="h-full w-full object-cover object-[50%_30%] lg:h-auto lg:object-contain"
					src="/formal_image.jpg"
					alt="Hero banner me amongst trees"
				/>
			</div>
		</div>
		<!-- Text -->
		<div
			class="relative flex flex-1 flex-col items-center justify-center lg:items-start lg:justify-start"
			in:fly={{ y: 20, duration: 600, delay: 100 }}
		>
			<div class="flex flex-col items-center justify-center gap-4 lg:items-start">
				<h1 class="text-[40px] font-[600] xs:text-4xl lg:text-5xl">About me</h1>
				<p>
					Hi, I'm Sunny, a current third year student at the University of New South Wales
					(UNSW) studying a Bachelor of Computer Science, planning to major in Artificial
					Intelligence and minor in Mathematics.
					<br />
					<br />
					I love building new things, tinkering on side projects (which you can find on this portfolio
					page), and learning something new every day. In my spare time, I enjoy taking photos, going
					on hikes, and travelling.

					<br />
					<br />
					The lists below are an overview, please see the portfolio tab for more detailed writeups
					on what I achieved in each role. For any questions, please email <a href="mailto:sunnychenaustralia@gmail.com" target="_blank" rel="noopener noreferrer"><u>sunnychenaustralia@gmail.com</u></a> or fill out
					the contact page.
				</p>
			</div>

			<Accordion.Root class="w-full" type="multiple" bind:value>
				<Accordion.Item class="border-dark-10 group border-b px-1.5" value="university">
					<Accordion.Header>
						<Accordion.Trigger
							class="flex w-full flex-1 items-center justify-between py-5 text-left text-[15px] font-medium transition-all [&[data-state=open]>span>svg]:rotate-180"
						>
							University (2024 - present)
							<span
								class="hover:bg-dark-10 inline-flex size-8 items-center justify-center rounded-[7px] bg-transparent transition-all"
							>
								<CaretDown class="size-[18px] transition-all duration-200" />
							</span>
						</Accordion.Trigger>
					</Accordion.Header>
					<Accordion.Content class="overflow-hidden text-sm tracking-[-0.01em]">
						{#snippet child({ open })}
							{#if open}
								<div class="pb-[25px]" transition:slide={{ duration: 500 }}>
									<b>Education:</b>
									<ul class="list-outside list-disc px-5 text-sm">
										<li>Dean's List 2024 & HD WAM</li>
										<li>UNSW Co-op Scholar (3x Internships)</li>
										<li>UNSW Scientia Scholarship</li>
										<li>Notable results: 94 Higher Mathematics 1A & 1B, 97 Higher Complex Analysis, 99 Software Engineering Fundamentals, 94 Algorithm Design and Analysis, 97 Introduction to Atmosphere and Ocean Dynamics (2nd in course)</li>
									</ul>

									<br />
									<b>Internships / work experience:</b>
									<ul class="list-outside list-disc px-5 text-sm">
										<li>
											Finance Systems / Business Analysis / Procurement Intern @ Reserve Bank of Australia (RBA) (Sep - Jan 2025)
										</li>
										<li>Lab tutor for Algorithm Design and Analysis (COMP3121) (Sep - Dec 2025)</li>
									</ul>

									<br />
									<b>Societies:</b>
									<ul class="list-outside list-disc px-5 text-sm">
										<li>CPMSoc Infrastructure Subcommittee (2026)</li>
										<li>UNSW Project Hope Vice President (2025)</li>
										<li>UNSW CSESoc Marketing Subcommittee (2024)</li>
									</ul>


									<!--									<br />-->
									<!--									<b>Hackathons:</b>-->
									<!--									<ul class="list-outside list-disc px-5 text-sm">-->
									<!--										<li>-->
									<!--											Got second place in a team of 5 for the 'AI EdTech Student Hackathon' ($300 prize) by Build Club x UNSW-->
									<!--											AI Society x Tutero-->
									<!--										</li>-->
									<!--									</ul>-->

									<br />
									<b>Frameworks / languages / libraries / software skills:</b>
									<ul class="list-outside list-disc px-5 text-sm">
										<li>
											<b>Frameworks / web services:</b> Spring Boot, Laravel, AWS, SvelteKit, React, CI/CD (GitHub actions), Docker, Django
										</li>
										<li>
											<b>Languages:</b> C, Java, C++, Python, JavaScript, PHP, Assembly, SQL (PostgreSQL), NoSQL (MongoDB)
										</li>
										<li>
											<b>Libraries:</b> PyTorch, TensorFlow, Scikit-learn, Matplotlib
										</li>
										<li>
											<b>Software skills:</b> Adobe Photoshop, Premiere Pro, After Effects, ArcGIS, Excel, Power BI, Vim, Jira, Miro, Microsoft Power Platform
										</li>
										<br/>
										<i class="text-sm">Note: This is not an exhaustive list</i>
									</ul>
								</div>
							{/if}
						{/snippet}
					</Accordion.Content>
				</Accordion.Item>

				<Accordion.Item class="border-dark-10 group border-b px-1.5" value="high_school">
					<Accordion.Header>
						<Accordion.Trigger
							class="flex w-full flex-1 items-center justify-between py-5 text-left text-[15px] font-medium transition-all [&[data-state=open]>span>svg]:rotate-180"
						>
							High School (&leq; 2023)
							<span
								class="hover:bg-dark-10 inline-flex size-8 items-center justify-center rounded-[7px] bg-transparent transition-all"
							>
								<CaretDown class="size-[18px] transition-all duration-200" />
							</span>
						</Accordion.Trigger>
					</Accordion.Header>
					<Accordion.Content forceMount={true} class="overflow-hidden text-sm tracking-[-0.01em]">
						{#snippet child({ open })}
							{#if open}
								<div class="pb-[25px]" transition:slide={{ duration: 500 }}>
									<b>Achievements:</b>
									<ul class="list-outside list-disc px-5 text-sm">
										<li>99.95 ATAR (top 0.05% of students)</li>
										<li>First in State for HSC Geography 2022</li>
										<li>Dux of Year 12: First in grade for English Advanced and Visual Arts</li>
										<li>Dux of Year 11: First in grade for Chemistry, Visual Arts and Geography</li>
										<li>
											Dux of Year 10: First in grade for Information and Software Technology (IST),
											Photography and Digital Media (PDM) and Electronics
										</li>
										<li>University of Sydney Year 10 Academic Excellence Award</li>
									</ul>

									<br />
									<b>Extracurricular:</b>
									<ul class="list-outside list-disc px-5 text-sm">
										<li>Prefect (2022 - 2023)</li>
										<li>Final End of Year 12 Assembly Committee (2023)</li>
										<li>Year 12 Jersey Design Committee (2023)</li>
										<li>RACI Titration Competition (2023)</li>
										<li>School Photographer (2021 - 2023)</li>
										<li>Environmental Committee (2019 - 2023)</li>
										<li>School Phoenix Magazine Editor (2022)</li>
										<li>Student Support Leader (2022)</li>
										<li>Peer Support Leader (2021)</li>
										<li>State Band 2 (2018 - 2021)</li>
										<li>2nd's Badminton Team (2020)</li>
									</ul>
								</div>
							{/if}
						{/snippet}
					</Accordion.Content>
				</Accordion.Item>
			</Accordion.Root>
		</div>
	</div>
</div>

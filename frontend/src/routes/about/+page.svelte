<script>
	import { fly } from 'svelte/transition';
	import { Accordion } from 'bits-ui';
	import CaretDown from 'phosphor-svelte/lib/CaretDown';
	import { slide } from 'svelte/transition';

	let value = $state(["university"]);
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
			<div class="flex flex-col gap-4">
				<h1 class="text-[40px] font-[600] xs:text-4xl lg:text-5xl">About me</h1>
				<p>
					Hi there! I'm Sunny, a current second year student at the University of New South Wales
					(UNSW) studying a Bachelor of Computer-Science (Co-op), planning to major in Artificial
					Intelligence and minor in Mathematics.
					<br />
					<br />
					I love building new things, tinkering on side projects (which you can find on this portfolio
					page), and learning something new every day. In my spare time, I enjoy taking photos, going
					on hikes, and travelling.

                    <br />
                    <br />
                    The lists below provide an overview, please see the portfolio tab for more detailed writeups on what I achieved in each role.
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
						{#snippet child({ props, open })}
							{#if open}
								<div class="pb-[25px]" transition:slide={{ duration: 500 }}>
									<b>Achievements:</b>
									<ul class="px-5 list-disc list-outside text-sm">
										<li>Dean's List 2024 & HD WAM</li>
										<li>UNSW Co-op Scholar (3x Internships & $21,800 p.a.)</li>
										<li>UNSW Scientia Scholarship</li>
									</ul>

									<br />
									<b>Societies / internships / work experience:</b>
                                    <ul class="px-5 list-disc list-outside text-sm">
                                        <li>Buisness Analysis Intern @ Reserve Bank of Australia (RBA) (Sep - Dec 2025)</li>
                                        <li>Lab tutor for Algorithm Design and Analysis (COMP3121) (Sep - Jan 2025)</li>
                                        <li>UNSW Project Hope Vice President (2025)</li>
                                        <li>UNSW CSESoc Marketing Subcommittee (2024)</li>
                                    </ul>

                                    <br />
                                    <b>Hackathons:</b>
                                    <ul class="px-5 list-disc list-outside text-sm">
                                        <li>Second place 'AI EdTech Student Hackathon' ($300 prize) by Build Club x UNSW AI Society x Tutero</li>
                                    </ul>


                                    <br />
                                    <b>Software skills / languages / frameworks / libraries (summary):</b>
                                    <ul class="px-5 list-disc list-outside text-sm">
                                        <li><b>Software skills:</b> Adobe Photoshop, Lightroom, Premiere Pro, After Effects, QGIS, ArcGIS, DaVinci Resolve, Blender, Microsoft SharePoint, Vim</li>
                                        <li><b>Languages:</b> C, Java, C++, PHP, React, Svelte, JavaScript, Assembly, Python, SQL (PostGreSQL), NoSQL (MongoDB)</li>
                                        <li><b>Frameworks:</b> Spring Boot, Laravel, Amazon Web Services (EC2, CloudFront, S3, Route 53, etc.), Nginx, SvelteKit, CI / CD (GitHub actions, etc.)</li>
                                        <li><b>Libraries:</b> TensorFlow, PyTorch, SciKit Learn, etc. (Mostly those used in AI)</li>
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
						{#snippet child({ props, open })}
							{#if open}
								<div {...props} transition:slide={{ duration: 500 }}>
									<div class="pb-[25px]">University has been an</div>
								</div>
							{/if}
						{/snippet}
					</Accordion.Content>
				</Accordion.Item>
			</Accordion.Root>
		</div>
	</div>
</div>

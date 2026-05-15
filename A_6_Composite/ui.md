<!DOCTYPE html>

<html class="light" lang="en"><head>
<meta charset="utf-8"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<title>Muhammad Samudera Bagja | Portfolio</title>
<script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script>
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<script id="tailwind-config">
        tailwind.config = {
          darkMode: "class",
          theme: {
            extend: {
              "colors": {
                      "on-background": "#1a1c1d",
                      "error-container": "#ffdad6",
                      "inverse-on-surface": "#f0f0f2",
                      "on-tertiary-container": "#2b82f4",
                      "surface-container-lowest": "#ffffff",
                      "outline": "#7e7576",
                      "on-surface-variant": "#4c4546",
                      "outline-variant": "#cfc4c5",
                      "surface-container-highest": "#e2e2e4",
                      "inverse-surface": "#2f3132",
                      "on-primary-fixed-variant": "#474747",
                      "on-tertiary-fixed": "#001b3f",
                      "on-primary": "#ffffff",
                      "on-primary-container": "#848484",
                      "primary-container": "#1b1b1b",
                      "surface-container": "#eeeef0",
                      "on-tertiary": "#ffffff",
                      "surface-bright": "#f9f9fb",
                      "tertiary": "#000000",
                      "background": "#f9f9fb",
                      "on-secondary-container": "#626267",
                      "tertiary-fixed-dim": "#abc7ff",
                      "on-secondary-fixed": "#1a1b1f",
                      "secondary": "#5e5e63",
                      "surface": "#f9f9fb",
                      "tertiary-container": "#001b3f",
                      "surface-tint": "#5e5e5e",
                      "on-secondary-fixed-variant": "#46464b",
                      "secondary-fixed-dim": "#c7c6cb",
                      "inverse-primary": "#c6c6c6",
                      "on-surface": "#1a1c1d",
                      "primary": "#000000",
                      "error": "#ba1a1a",
                      "on-secondary": "#ffffff",
                      "on-error": "#ffffff",
                      "secondary-fixed": "#e3e2e7",
                      "surface-container-low": "#f3f3f5",
                      "primary-fixed": "#e2e2e2",
                      "secondary-container": "#e0dfe4",
                      "surface-dim": "#d9dadc",
                      "on-error-container": "#93000a",
                      "tertiary-fixed": "#d7e2ff",
                      "surface-variant": "#e2e2e4",
                      "on-tertiary-fixed-variant": "#00458f",
                      "primary-fixed-dim": "#c6c6c6",
                      "on-primary-fixed": "#1b1b1b",
                      "surface-container-high": "#e8e8ea"
              },
              "borderRadius": {
                      "DEFAULT": "1rem",
                      "lg": "2rem",
                      "xl": "3rem",
                      "full": "9999px"
              },
              "spacing": {
                      "gutter": "24px",
                      "container-max": "1200px",
                      "margin-mobile": "20px",
                      "unit": "8px",
                      "section-gap": "160px"
              },
              "fontFamily": {
                      "body-md": ["Inter"],
                      "label-caps": ["Inter"],
                      "headline-md": ["Inter"],
                      "headline-lg": ["Inter"],
                      "display": ["Inter"],
                      "body-lg": ["Inter"]
              },
              "fontSize": {
                      "body-md": ["17px", {"lineHeight": "1.5", "letterSpacing": "-0.011em", "fontWeight": "400"}],
                      "label-caps": ["12px", {"lineHeight": "1.2", "letterSpacing": "0.05em", "fontWeight": "600"}],
                      "headline-md": ["28px", {"lineHeight": "1.3", "letterSpacing": "-0.018em", "fontWeight": "600"}],
                      "headline-lg": ["40px", {"lineHeight": "1.2", "letterSpacing": "-0.021em", "fontWeight": "600"}],
                      "display": ["64px", {"lineHeight": "1.1", "letterSpacing": "-0.022em", "fontWeight": "600"}],
                      "body-lg": ["19px", {"lineHeight": "1.5", "letterSpacing": "-0.011em", "fontWeight": "400"}]
              }
            },
          },
        }
    </script>
<style>
        body {
            background-color: #f9f9fb;
            color: #1a1c1d;
            scroll-behavior: smooth;
        }
        .glass-card {
            background: rgba(255, 255, 255, 0.7);
            backdrop-filter: blur(20px);
            border: 1px solid rgba(255, 255, 255, 0.2);
            box-shadow: 0 20px 40px rgba(0,0,0,0.04);
        }
        .fade-slide-up {
            animation: fadeSlideUp 0.8s cubic-bezier(0.4, 0, 0.2, 1);
        }
        @keyframes fadeSlideUp {
            from { opacity: 0; transform: translateY(20px); }
            to { opacity: 1; transform: translateY(0); }
        }
    </style>
</head>
<body class="font-body-md selection:bg-tertiary selection:text-white">
<!-- TopNavBar -->
<nav class="fixed top-0 left-1/2 -translate-x-1/2 z-50 flex items-center justify-between px-8 py-3 w-full max-w-3xl bg-white/70 backdrop-blur-md rounded-full border border-white/20 mt-6 shadow-[0_20px_40px_rgba(0,0,0,0.04)] backdrop-blur-2xl">
<span class="text-xl font-bold tracking-tighter text-black">Samudera.</span>
<div class="hidden md:flex items-center gap-8">
<a class="font-['Inter'] text-xs font-medium tracking-widest uppercase text-neutral-500 hover:opacity-70 transition-opacity duration-300" href="#about">About</a>
<a class="font-['Inter'] text-xs font-medium tracking-widest uppercase text-neutral-500 hover:opacity-70 transition-opacity duration-300" href="#stack">Stack</a>
<a class="font-['Inter'] text-xs font-medium tracking-widest uppercase text-neutral-500 hover:opacity-70 transition-opacity duration-300" href="#projects">Experience</a>
<a class="font-['Inter'] text-xs font-medium tracking-widest uppercase text-neutral-500 hover:opacity-70 transition-opacity duration-300" href="#projects">Projects</a>
</div>
<a class="font-['Inter'] text-xs font-bold tracking-widest uppercase text-black active:scale-95 transition-transform duration-200" href="#">Resume</a>
</nav>
<main class="max-w-container-max mx-auto px-margin-mobile md:px-gutter">
<!-- Hero Section -->
<section class="min-h-screen flex flex-col items-center justify-center text-center pt-20">
<div class="mb-12 relative fade-slide-up">
<div class="w-32 h-32 md:w-40 md:h-40 rounded-full overflow-hidden border-4 border-white shadow-xl">
<img class="w-full h-full object-cover" data-alt="Clean minimalist portrait of a professional young man in a white studio setting with soft natural light and high key exposure" src="https://lh3.googleusercontent.com/aida-public/AB6AXuCK9Txi0bIIkWZjhCW7w_N3d1EBVzug-ddI3aY-hkvZ2fQVWslkIOo_35TCGrEy13zfKSyootK8UXpdKpOLlGsQ23yE342GaVPKsl1iAFdVrxYre-ZZ3fCUk8jqdxlOEW59baVIxnsl6ijeuFejkmVeqth14HjNnkWszBA6WZ5FuNV8vblL9caoJZktJifMOu5Pk5TuvyI0wVI1DZfSICDxoJc8yHApeGVFpB9G43W5uQAL7Lf_-6oAf8P2m8LDXTLUbxfw-Z1gbA"/>
</div>
</div>
<h1 class="font-display text-display text-on-background mb-6 fade-slide-up">Hi, I'm Samudera.</h1>
<p class="font-headline-md text-headline-md text-secondary max-w-2xl mx-auto mb-10 fade-slide-up">Software Developer &amp; Founder of Vistara Photo.</p>
<div class="fade-slide-up">
<button class="bg-primary text-on-primary px-10 py-4 rounded-full font-label-caps uppercase tracking-widest hover:scale-105 active:scale-95 transition-all duration-300 shadow-lg">
                    View Resume
                </button>
</div>
</section>
<!-- About Section -->
<section class="py-section-gap" id="about">
<div class="max-w-3xl mx-auto">
<span class="font-label-caps text-on-tertiary-container mb-4 block">ABOUT ME</span>
<h2 class="font-headline-lg text-headline-lg mb-8">Crafting precise digital experiences through system design.</h2>
<div class="space-y-6 font-body-lg text-body-lg text-secondary">
<p>I am a Computer &amp; Informatics Engineering student at <span class="text-on-background font-medium">Politeknik Negeri Bandung</span>, currently expanding my horizons as an exchange student at <span class="text-on-background font-medium">Shandong University</span>.</p>
<p>My focus lies at the intersection of high-performance backend systems and sophisticated user interfaces. I specialize in developing robust server architectures and macOS-centric workflows that prioritize efficiency and elegant simplicity.</p>
</div>
</div>
</section>
<!-- Tech Stack Section -->
<section class="py-section-gap" id="stack">
<div class="max-w-5xl mx-auto">
<span class="font-label-caps text-on-tertiary-container mb-12 block text-center">TECHNICAL ECOSYSTEM</span>
<div class="grid grid-cols-2 md:grid-cols-4 gap-4">
<div class="bg-surface-container-low p-8 rounded-lg flex flex-col items-center justify-center gap-4 hover:bg-white hover:shadow-xl transition-all duration-300">
<span class="material-symbols-outlined text-4xl text-on-background">database</span>
<span class="font-label-caps text-on-background">Laravel</span>
</div>
<div class="bg-surface-container-low p-8 rounded-lg flex flex-col items-center justify-center gap-4 hover:bg-white hover:shadow-xl transition-all duration-300">
<span class="material-symbols-outlined text-4xl text-on-background">terminal</span>
<span class="font-label-caps text-on-background">Node.js</span>
</div>
<div class="bg-surface-container-low p-8 rounded-lg flex flex-col items-center justify-center gap-4 hover:bg-white hover:shadow-xl transition-all duration-300">
<span class="material-symbols-outlined text-4xl text-on-background">memory</span>
<span class="font-label-caps text-on-background">C Language</span>
</div>
<div class="bg-surface-container-low p-8 rounded-lg flex flex-col items-center justify-center gap-4 hover:bg-white hover:shadow-xl transition-all duration-300">
<span class="material-symbols-outlined text-4xl text-on-background">code</span>
<span class="font-label-caps text-on-background">PHP</span>
</div>
<div class="bg-surface-container-low p-8 rounded-lg flex flex-col items-center justify-center gap-4 hover:bg-white hover:shadow-xl transition-all duration-300">
<span class="material-symbols-outlined text-4xl text-on-background">dock</span>
<span class="font-label-caps text-on-background">Docker</span>
</div>
<div class="bg-surface-container-low p-8 rounded-lg flex flex-col items-center justify-center gap-4 hover:bg-white hover:shadow-xl transition-all duration-300">
<span class="material-symbols-outlined text-4xl text-on-background">layers</span>
<span class="font-label-caps text-on-background">Next.js</span>
</div>
<div class="bg-surface-container-low p-8 rounded-lg flex flex-col items-center justify-center gap-4 hover:bg-white hover:shadow-xl transition-all duration-300">
<span class="material-symbols-outlined text-4xl text-on-background">cloud</span>
<span class="font-label-caps text-on-background">Supabase</span>
</div>
<div class="bg-surface-container-low p-8 rounded-lg flex flex-col items-center justify-center gap-4 hover:bg-white hover:shadow-xl transition-all duration-300">
<span class="material-symbols-outlined text-4xl text-on-background">dns</span>
<span class="font-label-caps text-on-background">macOS Server</span>
</div>
</div>
</div>
</section>
<!-- Experience & Projects Section -->
<section class="py-section-gap" id="projects">
<div class="max-w-5xl mx-auto space-y-24">
<div class="grid md:grid-cols-2 gap-12 items-center">
<div class="order-2 md:order-1">
<span class="font-label-caps text-on-tertiary-container mb-4 block">SELECTED WORK</span>
<h3 class="font-headline-lg text-headline-lg mb-4">Vistara Photo</h3>
<p class="font-body-lg text-body-lg text-secondary mb-8">As Founder &amp; Lead Developer, I engineered a high-performance iPad SaaS solution for modern photobooth experiences, merging hardware integration with cloud-based management.</p>
<div class="flex gap-4">
<span class="bg-surface-container-highest px-4 py-1.5 rounded-full text-xs font-medium text-secondary">Swift</span>
<span class="bg-surface-container-highest px-4 py-1.5 rounded-full text-xs font-medium text-secondary">SaaS</span>
<span class="bg-surface-container-highest px-4 py-1.5 rounded-full text-xs font-medium text-secondary">Node.js</span>
</div>
</div>
<div class="glass-card aspect-[4/3] rounded-lg overflow-hidden order-1 md:order-2 group">
<img class="w-full h-full object-cover group-hover:scale-105 transition-transform duration-700" data-alt="Professional studio photobooth setup with soft lighting and minimalist equipment in a high-end modern gallery space" src="https://lh3.googleusercontent.com/aida-public/AB6AXuBwZ1PN2awlaNk09ap0V9T1oA7Y712TLG7AGLVZy7tPEZvjHPXHBz4rn4dALtt7jxCTo1nog-L2db8ssgl1OKylUuLjZF7StFAyOgk1eo50-B665S3_9REX76bbb6Fuv9siE_1QrxYwDijt96Sisubi-WQZ7tL5ceisLvbowgPX6NDHaedwP0ClM7pf5tt39WC2GI8Xd2oiQKxw-EVRiW6cl9kt-Llw327TiMgvHgH7I-RaOsSjd8T6RF7vXQb6NdH-fwphCwMrhA"/>
</div>
</div>
<div class="grid md:grid-cols-2 gap-12 items-center">
<div class="glass-card aspect-[4/3] rounded-lg overflow-hidden group">
<img class="w-full h-full object-cover group-hover:scale-105 transition-transform duration-700" data-alt="Close-up of a MacBook Pro showing clean code on a minimalist white desk with a small plant and soft morning light" src="https://lh3.googleusercontent.com/aida-public/AB6AXuDMM6bPxijaj-_RgJ9l6X01Ky7rqGReMqZD8rf644boghXvCr5HGW1mciYYRspX5lLgDVgRlaMLglLLl_VgFTqzSSCV0qZoTPjHyvTczK94akM6wAXRY_Bp15SYxnwuk8ZV5tfJ3CT6XZyyppA4yNXQ8ajKNkmx3hc0SQH6MCaZQOz9-qRO2iHh1D0RZnDnXjZPfv1qDKp3S-Z_cYGr86WNf0DLgqLLEjrCmrZLV1sCaY9Lt1Q4e06Bs3onMuv-2a1-OswksFqTjw"/>
</div>
<div>
<span class="font-label-caps text-on-tertiary-container mb-4 block">PERSONAL PROJECT</span>
<h3 class="font-headline-lg text-headline-lg mb-4">msamudera.dev</h3>
<p class="font-body-lg text-body-lg text-secondary mb-8">A personal digital garden and professional portfolio built with Next.js and a Headless CMS, focusing on typography-driven design and fluid transitions.</p>
<div class="flex gap-4">
<span class="bg-surface-container-highest px-4 py-1.5 rounded-full text-xs font-medium text-secondary">Next.js</span>
<span class="bg-surface-container-highest px-4 py-1.5 rounded-full text-xs font-medium text-secondary">Headless CMS</span>
<span class="bg-surface-container-highest px-4 py-1.5 rounded-full text-xs font-medium text-secondary">Tailwind</span>
</div>
</div>
</div>
</div>
</section>
</main>
<!-- Footer -->
<footer class="bg-transparent full-width pb-20 pt-40">
<div class="max-w-7xl mx-auto px-8 flex flex-col md:flex-row justify-between items-center gap-8">
<div class="flex flex-col gap-4 text-center md:text-left">
<span class="text-lg font-semibold text-black">Samudera.</span>
<p class="font-['Inter'] text-sm text-neutral-500 font-body-md">© 2024 Muhammad Samudera Bagja. Built with precision.</p>
</div>
<div class="flex items-center gap-8">
<a class="font-['Inter'] text-sm text-neutral-500 hover:text-black transition-colors ease-in-out duration-300" href="#">LinkedIn</a>
<a class="font-['Inter'] text-sm text-neutral-500 hover:text-black transition-colors ease-in-out duration-300" href="#">GitHub</a>
<a class="font-['Inter'] text-sm text-neutral-500 hover:text-black transition-colors ease-in-out duration-300" href="#">Twitter</a>
<a class="font-['Inter'] text-sm text-neutral-500 hover:text-black transition-colors ease-in-out duration-300" href="#">Email</a>
</div>
<button class="bg-primary text-on-primary px-8 py-3 rounded-full font-label-caps uppercase tracking-widest text-xs hover:scale-105 active:scale-95 transition-all duration-300">
                Download Resume
            </button>
</div>
</footer>
</body></html>
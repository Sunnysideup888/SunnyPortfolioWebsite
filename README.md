# Portfolio Website

This is a full stack portfolio website made entirely from scratch. The frontend is made using SvelteKit (the Svelte framework), and the backend runs on Spring Boot (a Java framework), with blogs stored in a PostgreSQL database. It features CI/CD pipelines which redeploy's the application for each git commit / merge into main, with the backend going onto an EC2 instance with Nginx configured to act as a web server, and the frontend going to a static S3 bucket served on CloudFront.

Some features of this project include:
- Custom markdown blogs which can render LaTeX
- Email functionality with a custom domain using Amazon Simple Email Service
- CI/CD pipelines
- Full text search across all blogs and projects using PostgreSQL `tsvector` and `tsquery`

The frontend uses:
- SvelteKit
- Bits-ui for styling
- Aceternity UI
- Compiled and put on S3 buckets, then cached using CloudFront for fast loading

The backend runs on:
- Spring Boot (a Java framework)
- Amazon Simple Email Service (for contact page)
- Amazon EC2 with Nginx (for hosting the Spring Boot application)
- PostgreSQL to store all blog posts and for full text search
- S3 bucket for images in the gallery, which has infinite pagination on the frontend side
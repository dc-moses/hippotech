FROM node:12.20.1-alpine3.12
COPY package.json package.json
COPY package-lock.json package-lock.json
COPY blog.js blog.js
RUN npm install
CMD ["npm", "start"]
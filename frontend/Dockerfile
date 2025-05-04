FROM node:20.12.2-slim
WORKDIR /app

COPY package*.json ./
RUN npm install -g @angular/cli@17
RUN npm install
COPY . .

EXPOSE 4200
CMD ["npm", "run", "prod"]

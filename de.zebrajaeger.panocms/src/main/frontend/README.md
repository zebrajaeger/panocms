### Frontend Workflow

#### Requirements
The implemented workflow requires the following tools to be installed:
* Node.js (v7.1.0)
* Node Package Manager - npm (v3.10.9)

After installing Node.js and npm install these packages in global scope:
```bash
npm install -g bower eslint gulp-cli
```

### Project Initialisation
First, switch to the correct working directory:
```bash
<modul>/src/main/frontend/
```
After that run the following command to install all required modules and dependencies for the frontend workflow:
```bash
npm install && bower install
```

### Workflow Tasks
The workflow depends on several predefined tasks. Every task can be run in development mode without any parameters or in production mode by adding `--env production`.

If you want to build only parts of the frontend, use one of these tasks:
```bash
gulp build-css
gulp build-js
gulp build-html
gulp build-assets
```

If you want to build the whole frontend (`build`) or watch changes without (`watch`) or with serving it (`serve`) on a local development server, use one of the following tasks:
```bash
gulp build
gulp watch
gulp serve
```

# HW5
Homework 5

Please find screencast at https://www.youtube.com/watch?v=J0Pv0hEAW7w

##Setup: Install the following items:

###Install node.js

```
      - name: nodejs setup
        #sudo: yes
        become: yes
        become_method: sudo
        shell: curl -sL https://deb.nodesource.com/setup_6.x | sudo -E bash -
      - name: install nodejs and npm
        #sudo: yes
        become: yes
        become_method: sudo
        shell: apt-get install -y nodejs
```

###Install forever

```
    - name: Install forever
        become: yes
        become_method: sudo
        npm: 
          name: forever 
          global: yes 
          state: present
```

###Pull/clone git repo into a destination: https://github.com/CSC-DevOps/App
```
      - name: Install git
        become: yes
        become_method: sudo
        apt:
          name: git
          state: present
          update_cache: true
      - name: git clone repo
        git: 
          repo: https://github.com/CSC-DevOps/App.git 
          dest: ./App
          clone: yes
```

###Install npm packages
```
- name: install all npm packages
        npm:
          path: "{{ playbook_dir }}/App"
```

##Tasks:

###Run app: forever start node main.js
```
 - name: run app using forever
        command: forever start "{{ playbook_dir }}/App/main.js" 8000
```

###Security: Create a task that ensures bash, openssl, openssh-client, and openssh-server are running latest version.
```
- name: Install bash, openssl, openssh-client, and openssh-server
        become: yes
        become_method: sudo
        apt: name={{item}} state=latest
        with_items:
         - bash
         - openssl
         - openssh-client
         - openssh-server
```

###Cleanup: Remove content in /tmp/*
```
  - name: clear contents of  /tmp directory
        become: yes
        become_method: sudo
        file: path=/tmp/ state=absent
      - pause: seconds=5 prompt="waiting for 5 seconds"
      - name: create the tmp directory again
        become: yes
        become_method: sudo
        file: path=/tmp/* state=directory
```

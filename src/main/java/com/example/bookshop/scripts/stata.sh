#!/usr/bin/env bash
sudo -u postgres psql<<EOF
drop database bookshop;
create database bookshop;

EOF
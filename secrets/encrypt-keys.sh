#!/bin/bash
if [ -z "$1" ]; then
    echo 'You must provide secret key as first param' >&2
    exit 2
else
    openssl aes-256-cbc -md sha256 -nosalt -a -pass pass:$1 -in secrets/keystore.properties -out secrets/keystore.properties.crypted
fi

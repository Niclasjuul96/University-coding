#from distutils.utils import convert_path
from typing import Dict
from setuptools import setup, find_packages

version_dict = {}

with open("02450Toolbox_Python/version.py") as f:
    exec(f.read(), version_dict)

setup(
    name = "02450Toolbox_Python",
    version='1.0.0',
    long_description="",
    classifiers=["Programming Language :: Python ::"],
    packages = ['02450Toolbox_Python', '02450Toolbox_Python.Scripts'],
    include_package_data=True,
    install_requires=[],
    zip_safe=False)
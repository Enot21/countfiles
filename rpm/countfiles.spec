Name: countfiles
Version: 1.0
Release: 1%{?dist}
Summary: Script to count files in /etc directory
Requires: unzip

License: MIT
URL: https://github.com/Enot21/countfiles
Source0: https://github.com/Enot21/countfiles/archive/main.zip

BuildArch: noarch

%description
Package includes a script for tallying files within the /etc directory.

%prep
unzip %SOURCE0
cd countfiles-main/

%install
mkdir -p %{buildroot}/usr/bin
install -m 755 %{_builddir}/countfiles-main/count_files.sh %{buildroot}/usr/bin/count_files

%files
/usr/bin/count_files

%changelog
* Wed Jan 17 2024 Sokolenko Vladyslav <enot75726@gmail.com> - 1.0-1
- Initial build

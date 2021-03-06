include $(top_srcdir)/config/Rules.am

DEFAULT_INCLUDES += \
	-I$(top_srcdir)/include \
	-I$(top_srcdir)/lib/libspl/include

sbin_PROGRAMS = zpool

zpool_SOURCES = \
	zpool_iter.c \
	zpool_main.c \
	zpool_util.c \
	zpool_util.h \
	zpool_vdev.c

zpool_LDADD = \
	$(top_builddir)/lib/libnvpair/libnvpair.la \
	$(top_builddir)/lib/libuutil/libuutil.la \
	$(top_builddir)/lib/libzfs/libzfs.la \
	$(top_builddir)/lib/libzfs_core/libzfs_core.la \
	$(top_builddir)/lib/libzutil/libzutil.la \
	-lssl -lcrypto -ltirpc -luutil

zpool_LDADD += -lm $(LIBBLKID)

zpoolconfdir = $(sysconfdir)/zfs/zpool.d
zpoolexecdir = $(zfsexecdir)/zpool.d

EXTRA_DIST = zpool.d/README

dist_zpoolexec_SCRIPTS = \
	zpool.d/enc \
	zpool.d/encdev \
	zpool.d/fault_led \
	zpool.d/iostat \
	zpool.d/iostat-1s \
	zpool.d/iostat-10s \
	zpool.d/label \
	zpool.d/locate_led \
	zpool.d/lsblk \
	zpool.d/media \
	zpool.d/model \
	zpool.d/serial \
	zpool.d/ses \
	zpool.d/size \
	zpool.d/slaves \
	zpool.d/slot \
	zpool.d/smart \
	zpool.d/smartx \
	zpool.d/temp \
	zpool.d/health \
	zpool.d/r_proc \
	zpool.d/w_proc \
	zpool.d/r_ucor \
	zpool.d/w_ucor \
	zpool.d/nonmed \
	zpool.d/defect \
	zpool.d/hours_on \
	zpool.d/realloc \
	zpool.d/rep_ucor \
	zpool.d/cmd_to \
	zpool.d/pend_sec \
	zpool.d/off_ucor \
	zpool.d/ata_err \
	zpool.d/nvme_err \
	zpool.d/pwr_cyc \
	zpool.d/upath \
	zpool.d/vendor \
	zpool.d/smart_test \
	zpool.d/test_type \
	zpool.d/test_status \
	zpool.d/test_progress \
	zpool.d/test_ended

zpoolconfdefaults = \
	enc \
	encdev \
	fault_led \
	iostat \
	iostat-1s \
	iostat-10s \
	label \
	locate_led \
	lsblk \
	media \
	model \
	serial \
	ses \
	size \
	slaves \
	slot \
	smart \
	smartx \
	temp \
	health \
	r_proc \
	w_proc \
	r_ucor \
	w_ucor \
	nonmed \
	defect \
	hours_on \
	realloc \
	rep_ucor \
	cmd_to \
	pend_sec \
	off_ucor \
	ata_err \
	nvme_err \
	pwr_cyc \
	upath \
	vendor \
	smart_test \
	test_type \
	test_status \
	test_progress \
	test_ended

install-data-hook:
	rm -rf "$(DESTDIR)$(zpoolexecdir)"
	$(MKDIR_P) "$(DESTDIR)$(zpoolexecdir)"
	cp -fpR $(dist_zpoolexec_SCRIPTS) $(DESTDIR)$(zpoolexecdir)
